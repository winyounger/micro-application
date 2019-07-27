package com.supconit.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.supconit.dao.domain.UserDo;
import com.supconit.dao.dto.UserDto;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 13:39:11
 * @Description:
 * @Version: 1.0.0
 */
public interface UserMapper extends BaseMapper<UserDo> {


    /**
     * description
     * @param wechatOpenid 微信openid
     * @return user
     * */
    UserDto getUserByWechatOpenid(@Param("wechatOpenid") String wechatOpenid);

    Integer insert(UserDto userDto);

    void updateById(UserDto userDoExist);
}
