package com.wangyx.sell.repository;

import com.wangyx.sell.entity.OrderMasterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author xxxx
 * @Date 2020/2/23 21:48
 * @Version 1.0
 */
public interface OrderMasterRepository extends JpaRepository<OrderMasterEntity, String> {

    Page<OrderMasterEntity> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
