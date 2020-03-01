package com.wangyx.sell.exceptions;

import com.wangyx.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:26
 * @Version 1.0
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
