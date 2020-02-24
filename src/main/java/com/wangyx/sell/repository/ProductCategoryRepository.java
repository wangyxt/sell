package com.wangyx.sell.repository;

import com.wangyx.sell.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity,Integer> {

    List<ProductCategoryEntity> findByCategoryTypeIn(List<Integer> list);
}
