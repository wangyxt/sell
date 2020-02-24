package com.wangyx.sell.exceptions;

import com.wangyx.sell.enums.ResultEnum;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:26
 * @Version 1.0
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
}