package com.xmcc.wx_sell.common;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0, "成功"),
    FAILE(1, "失败"),
    NOT_EXITS(2, "不存在");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
