package com.wangyx.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.wangyx.sell.dto.OrderDTO;

public interface PayService {

    PayResponse create(OrderDTO orderDTO);
}