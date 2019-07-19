package com.supconit.domain.dto;

import lombok.Data;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 10:50:18
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class UserDto {

    private Long id;
    private String userName;
    private String password;
    private String wechatOpenid;
    private String phone;
    private String nickName;
    private Integer genderValue;
    private String email;
    private String gmtCreate;
    private String gmtModify;
//    private Long updateMillon;
    private String thirdSessionKey;

}
