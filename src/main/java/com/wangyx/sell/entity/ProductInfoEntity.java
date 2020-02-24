package com.wangyx.sell.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "product_info", schema = "sell", catalog = "")
public class ProductInfoEntity {
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private int productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus;
    private int categoryType;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_price")
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "product_stock")
    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    @Basic
    @Column(name = "product_description")
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Basic
    @Column(name = "product_icon")
    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    @Basic
    @Column(name = "product_status")
    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    @Basic
    @Column(name = "category_type")
    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfoEntity that = (ProductInfoEntity) o;
        return productStock == that.productStock &&
                categoryType == that.categoryType &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productPrice, that.productPrice) &&
                Objects.equals(productDescription, that.productDescription) &&
                Objects.equals(productIcon, that.productIcon) &&
                Objects.equals(productStatus, that.productStatus) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productPrice, productStock, productDescription, productIcon, productStatus, categoryType, createTime, updateTime);
    }
}
