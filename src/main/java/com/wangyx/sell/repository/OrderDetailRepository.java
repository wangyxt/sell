package com.wangyx.sell.repository;

import com.wangyx.sell.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author xxxx
 * @Date 2020/2/23 21:50
 * @Version 1.0
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,String> {

    List<OrderDetailEntity> findByOrderId(String orderId);
}
