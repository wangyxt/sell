package com.wangyx.sell.enums;

import lombok.Getter;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:26
 * @Version 1.0
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(100,"商品不存在"),
    PRODUCT_STOCK_ERROR(111,"库存不正确")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
