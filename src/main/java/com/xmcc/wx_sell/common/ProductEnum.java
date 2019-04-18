package com.xmcc.wx_sell.common;

import lombok.Getter;

@Getter
public enum ProductEnum {

    PRODUCT_DOWN(0, "订单已下架"),
    PRODUCT_NOT_ENOUGH(1, "库存不足");

    private Integer code;
    private String msg;
    ProductEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
