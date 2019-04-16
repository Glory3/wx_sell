package com.xmcc.wx_sell.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> {
    private int code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResultData(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static ResultData faile(){
        return new ResultData(ResultEnum.FAILE.getCode(), ResultEnum.FAILE.getMsg());
    }

    public static ResultData faile(String msg){
        return new ResultData(ResultEnum.FAILE.getCode(), msg);
    }
    public static <T> ResultData faile(String msg, T data){
        return new ResultData(ResultEnum.FAILE.getCode(), msg, data);
    }
    public static <T> ResultData faile(T data){
        return new ResultData(ResultEnum.FAILE.getCode(), ResultEnum.FAILE.getMsg(), data);
    }

    public static ResultData success(){
        return new ResultData(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg());
    }
    public static <T> ResultData success(T data){
        return new ResultData(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

}
