package com.wangyx.sell.enums;

import lombok.Getter;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:26
 * @Version 1.0
 */
@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),
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
    WECHAT_MP_ERROR(11,"微信公众账号方面错误"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(22,"微信支付异步通知金额校验不通过"),
    ORDER_CANCEL_SUCCESS(33,"订单取消成功"),
    ORDER_FINISH_SUCCESS(44,"订单完结成功"),
    PRODUCT_STATUS_ERROR(55,"商品状态不正确"),
    LOGIN_FAIL(66,"登录失败，登录信息不正确"),
    LOGOUT_SUCCESS(77,"等出成功"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
