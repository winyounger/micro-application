package com.supconit.query;

import lombok.Data;

@Data
public class CommonQuery {
    private Long userId;
    private String userName;

    //注册司机
    private String carName;
    private String carColor;
    private String carNumber;

}
