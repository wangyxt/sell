package com.wangyx.sell.service.impl;

import com.wangyx.sell.entity.ProductCategoryEntity;
import com.wangyx.sell.repository.ProductCategoryRepository;
import com.wangyx.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategoryEntity findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<ProductCategoryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategoryEntity> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategoryEntity save(ProductCategoryEntity productCategoryEntity) {
        return repository.save(productCategoryEntity);
    }
}
