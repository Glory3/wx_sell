package com.xmcc.wx_sell.exception;

import com.xmcc.wx_sell.common.ResultEnum;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private int  code;

    public CustomException(int code,String message){
        super(message);
        this.code = code;
    }
    public CustomException(String message){
        this(ResultEnum.FAILE.getCode(),message);
    }

}
