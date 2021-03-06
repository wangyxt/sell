package com.wangyx.sell.service;

import com.wangyx.sell.dto.OrderDTO;
import com.wangyx.sell.entity.OrderMasterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:12
 * @Version 1.0
 */
public interface OrderService {

    /** 创建订单 */
    OrderDTO create(OrderDTO orderDTO);
    /**查询单个订单*/
    OrderDTO findOne(String orderId);
    /**查询单个 订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    /** 取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);
    /** 完结订单*/
    OrderDTO finish(OrderDTO orderDTO);
    /** 支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

    /**查询所有订单列表*/
    Page<OrderDTO> findList(Pageable pageable);
}
