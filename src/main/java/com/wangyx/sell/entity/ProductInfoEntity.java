package com.wangyx.sell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wangyx.sell.enums.ProductStatusEnum;
import com.wangyx.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "product_info", schema = "sell")
@DynamicUpdate
@Data
public class ProductInfoEntity implements Serializable {
    private static final long serialVersionUID = 3858870735981220627L;
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private int productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    private int categoryType;
    private Date createTime;
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
