package com.supconit.dao.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 10:50:18
 * @Description:
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class UserDto {

    private Long id;
    private String avatarUrl;
    private String city;
    private String country;
    private Integer gender;//1 男，2 女
    private String language;
    private String nickName;
    private String province;
    private String openid;

    private String userName;
    private String password;
    private String mobile;
    private String email;
    private String gmtCreate;
    private String gmtModify;
    private String thirdSessionKey;

}
