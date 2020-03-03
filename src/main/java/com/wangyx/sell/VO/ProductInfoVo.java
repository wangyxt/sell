package com.wangyx.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品详情
 * @Author xxxx
 * @Date 2020/2/23 15:41
 * @Version 1.0
 */
@Data
public class ProductInfoVo implements Serializable {

    private static final long serialVersionUID = -8990519953067312203L;
    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
