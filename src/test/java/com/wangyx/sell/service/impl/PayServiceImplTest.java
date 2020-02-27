package com.wangyx.sell.service.impl;

import com.wangyx.sell.dto.OrderDTO;
import com.wangyx.sell.service.OrderService;
import com.wangyx.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void createTest() {
        OrderDTO orderDTO = orderService.findOne("1582531412827754996");
        payService.create(orderDTO);
    }
    @Test
    public void refundTest(){
        OrderDTO orderDTO = orderService.findOne("1582470844309108056");
        payService.refund(orderDTO);
    }
}