package com.supconit.dao.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月24日 21:24:19
 * @Description: 乘客发布信息的参数实体，参数暂时没时间写全，统一调试的时候再来补全
 * @Version: 1.0.0
 */
@Data
public class PublishMsg {

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
