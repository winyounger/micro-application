package com.supconit.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.supconit.core.enums.ResponseCodeEnum;
import com.supconit.core.response.ResponseData;
import com.supconit.core.api.WechatAuthCodeResponse;
import com.supconit.core.config.AppContext;
import com.supconit.core.config.WechatAuthConfig;
import com.supconit.core.util.DateUtil;
import com.supconit.core.util.TokenUtils;
import com.supconit.dao.dto.UserDto;
import com.supconit.dao.mapper.UserMapper;
import com.supconit.service.WechatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 11:01:57
 * @Description:
 * @Version: 1.0.0
 */
@Service("wechatService")
public class WechatServiceImpl implements WechatService {

    private static final Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);

    @Resource
    private UserMapper userMapper;
    @Autowired
    private TokenUtils tokenUtils;
    /**
     * 服务器第三方session有效时间， 默认30天
     */
    private static final Integer EXPIRES = 30;
    private RestTemplate wxAuthRestTemplate = new RestTemplate();
    @Autowired
    private WechatAuthConfig wechatAuthConfig;

    @Override
    @Transactional
    public ResponseData wechatLogin(String code) throws Exception {
        WechatAuthCodeResponse response = getWxSession(code);
        String wxOpenId = response.getOpenid();
        String wxSessionKey = response.getSession_key();
        UserDto userDto = new UserDto();
        userDto.setOpenid(wxOpenId);
        UserDto userDto1 = loginOrRegisterConsumer(userDto);
        Integer expires = response.getExpireTime();
        String thirdSession = create3rdSession(wxOpenId, wxSessionKey, expires, userDto1);
        return new ResponseData(thirdSession);
    }


    public WechatAuthCodeResponse getWxSession(String code) {
        logger.info(code);
        String urlString = "?appid={appid}&secret={srcret}&js_code={code}&grant_type={grantType}";
        String response = wxAuthRestTemplate.getForObject(
                wechatAuthConfig.getSessionHost() + urlString, String.class,
                wechatAuthConfig.getAppId(),
                wechatAuthConfig.getSecret(),
                code,
                wechatAuthConfig.getGrantType());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader reader = objectMapper.readerFor(WechatAuthCodeResponse.class);
        WechatAuthCodeResponse res;
        try {
            res = reader.readValue(response);
        } catch (IOException e) {
            res = null;
            logger.error("反序列化失败", e);
        }
        logger.info("wx response:",response);
        if (null == res) {
            throw new RuntimeException("调用微信接口失败");
        }
        if (res.getErrorcode() != null) {
            throw new RuntimeException(res.getErrmsg());
        }
        res.setExpireTime(res.getExpireTime() != null ? res.getExpireTime() : EXPIRES);
        return res;
    }

    public String create3rdSession(String wxOpenId, String wxSessionKey, Integer expires, UserDto userDto) throws Exception {
//        String thirdSessionKey = RandomStringUtils.randomAlphanumeric(64);
        StringBuffer sb = new StringBuffer();
        sb.append(wxSessionKey).append("#").append(wxOpenId);
//        stringRedisTemplate.opsForValue().set(thirdSessionKey, sb.toString(), expires, TimeUnit.SECONDS);
        String thirdSessionKey = tokenUtils.createToken(wxOpenId,userDto.getId(),userDto.getUserName(), DateUtil.addDays(new Date(), expires));
        return thirdSessionKey;
    }

    private UserDto loginOrRegisterConsumer(UserDto userDto) {
        UserDto userDo = userMapper.getUserByWechatOpenid(userDto.getOpenid());
        if (null == userDo) {
            userMapper.insert(userDto);
            return userDto;
        }
        return userDo;
    }

    @Override
    public ResponseData updateConsumerInfo(UserDto userDto) {
        UserDto userDoExist = userMapper.getUserByWechatOpenid(AppContext.getCurrentUserWechatOpenId());
        userDto.setId(userDoExist.getId());
        userMapper.updateById(userDto);
        return new ResponseData(ResponseCodeEnum.SUCCESS.getCode());
    }

}
