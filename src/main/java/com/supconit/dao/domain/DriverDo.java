package com.supconit.dao.domain;

import lombok.Data;

@Data
public class DriverDo {
    private Long id;
    private Integer isDelete;
    private String gmtCreate;
    private String gmtModify;
    private String creater;
    private String modifier;
    private String carName;
    private String carColor;
    private String carNumber;
    private Long userId;
}
