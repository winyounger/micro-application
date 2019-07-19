package com.supconit.mapper;

import com.supconit.domain.dto.UserDto;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 13:39:11
 * @Description:
 * @Version: 1.0.0
 */
public interface UserMapper {


    /**
     * description
     * @param wechatOpenid 微信openid
     * @return user
     * */
    UserDto getUserByWechatOpenid(@Param("wechatOpenid") String wechatOpenid);

    Integer insert(UserDto userDto);

    void updateById(UserDto userDoExist);
}
