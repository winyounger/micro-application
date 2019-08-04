package com.supconit.dao.domain;

import lombok.Data;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 10:52:48
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class UserDo {

    private Long id;
    private Integer isDelete;
    private String gmtCreate;
    private String gmtModify;
    private String creater;
    private String modifier;
    private String userName;
    private String nickName;
    private Long mobile;
    private String avatar;
    private Integer sex;
    private String email;
    private String openId;
    private String password;
    private String thirdSessionId;
    public String code;
}
