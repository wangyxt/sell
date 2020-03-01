package com.wangyx.sell.service;

import com.wangyx.sell.dto.OrderDTO;

/**
 * 推送消息
 * @Author xxxx
 * @Date 2020/3/1 14:53
 * @Version 1.0
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
