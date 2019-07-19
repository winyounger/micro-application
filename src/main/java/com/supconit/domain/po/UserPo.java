package com.supconit.domain.po;

import com.supconit.common.enums.Gender;
import lombok.Data;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 10:52:48
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class UserPo {

    private Long id;
    private String username;
    private Long phone;
    private Integer genderValue;
    private String vcode;
    private String password;
    private String promotionCode;
    private String InvitationCode;
    private String clientAssertion;
    private String code;

}
