package com.supconit.common.enums;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 10:53:34
 * @Description:
 * @Version: 1.0.0
 */
public enum Gender {

    UNKNOW(0, "未知"),
    MAN(1, "先生"),
    WOMAN(2, "女士");
    private Byte value;
    private String name;
    Gender(int value, String name) {
        this.value = (byte)value;
        this.name = name;
    }
    public Byte getValue() {
        return this.value;
    }
    public String getName() {
        return this.name;
    }

}
