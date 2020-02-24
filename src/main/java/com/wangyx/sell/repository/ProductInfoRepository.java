package com.wangyx.sell.repository;

import com.wangyx.sell.entity.ProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfoEntity,String> {

    List<ProductInfoEntity> findByProductStatus(Integer status);
}
