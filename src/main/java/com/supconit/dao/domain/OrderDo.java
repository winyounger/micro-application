package com.supconit.dao.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDo {
    private Long id;
    private Integer isDelete;
    private String gmtCreate;
    private String gmtModify;
    private String creater;
    private String modifier;
    private String note;
    private Date startTime;
    private Date endTime;
    private String startSite;
    private String endSite;
    private String mobile;
    private Integer seats;
    private String remark;
    private Integer type;
    private Long userId;
    private BigDecimal amount;
}
