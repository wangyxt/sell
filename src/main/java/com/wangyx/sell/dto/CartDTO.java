package com.wangyx.sell.dto;

import lombok.Data;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:45
 * @Version 1.0
 */
@Data
public class CartDTO {
    /** 商品id*/
    private String productId;
    /** 数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
