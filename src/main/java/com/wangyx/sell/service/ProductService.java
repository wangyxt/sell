package com.wangyx.sell.service;

import com.wangyx.sell.dto.CartDTO;
import com.wangyx.sell.entity.ProductInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 */
public interface ProductService {

    ProductInfoEntity findOne(String infoId);

    /**
     * 查询所有在架商品
     * @return
     */
    List<ProductInfoEntity> findUpAll();

    Page<ProductInfoEntity> findAll(Pageable pageable);

    ProductInfoEntity save(ProductInfoEntity productInfoEntity);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseSotck(List<CartDTO> cartDTOList);
}
