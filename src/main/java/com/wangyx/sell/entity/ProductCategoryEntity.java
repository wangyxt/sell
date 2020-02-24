package com.wangyx.sell.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "product_category", schema = "sell")
@DynamicInsert
public class ProductCategoryEntity {

    @Id
    @GeneratedValue
    private int categoryId;
    private String categoryName;
    private int categoryType;

    public ProductCategoryEntity() {
    }

    public ProductCategoryEntity(int categoryId, String categoryName, int categoryType) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    @Id
    @Column(name = "category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductCategoryEntity{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }

    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "category_type")
    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryEntity that = (ProductCategoryEntity) o;
        return categoryId == that.categoryId &&
                categoryType == that.categoryType &&
                Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, categoryType);
    }
}
