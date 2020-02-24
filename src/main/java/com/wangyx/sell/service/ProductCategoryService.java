package com.wangyx.sell.service;

import com.wangyx.sell.entity.ProductCategoryEntity;

import java.util.List;

public interface ProductCategoryService {

    ProductCategoryEntity findOne(Integer id);

    List<ProductCategoryEntity> findAll();

    List<ProductCategoryEntity> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategoryEntity save(ProductCategoryEntity productCategoryEntity);
}
