package com.supconit.dao.domain;

import lombok.Data;

@Data
public class DriverDo {
    private Long id;
    private String carName;
    private String carColor;
    private String carNumber;
    private Long userId;
}
