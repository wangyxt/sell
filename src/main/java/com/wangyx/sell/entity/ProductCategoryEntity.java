package com.wangyx.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@DynamicUpdate
@Data
@Table(name = "product_category", schema = "sell")
public class ProductCategoryEntity {

    /** 类目id. */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategoryEntity() {
    }

    public ProductCategoryEntity(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
