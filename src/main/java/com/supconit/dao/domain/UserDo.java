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
    private String userName;
    private Long mobile;
    private String avatar;
    private Integer sex;
    private String openId;
    private String password;
    private String promotionCode;
    private String InvitationCode;
    private String clientAssertion;
    private String code;

}
