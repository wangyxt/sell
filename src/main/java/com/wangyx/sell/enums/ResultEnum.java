package com.wangyx.sell.enums;

import lombok.Getter;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:26
 * @Version 1.0
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(100,"商品不存在"),
    PRODUCT_STOCK_ERROR(111,"库存不正确"),
    ORDER_NOT_EXIST(222,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(333,"订单详情不存在"),
    ORDER_STATUS_ERROR(444,"订单状态不正确"),
    ORDER_UPDATE_FAIL(555,"订单更新失败"),
    ORDER_DETAIL_EMPTY(666,"订单详情为空"),
    PAY_STATUS_ERROR(777,"支付状态不正确"),
    CART_EMPTY(888,"购物车为空"),
    ORDER_OWNER_ERROR(999,"该订单不属于当前用户"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
