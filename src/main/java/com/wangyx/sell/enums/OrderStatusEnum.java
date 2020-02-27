package com.wangyx.sell.enums;

import lombok.Getter;

/**
 * @Author xxxx
 * @Date 2020/2/23 21:09
 * @Version 1.0
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {

    NEW(0,"新订单"),
    FINISHED(1,"完结订单"),
    CANCEL(2,"已取消")
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
