package com.wangyx.sell.service.impl;

import com.wangyx.sell.dto.OrderDTO;
import com.wangyx.sell.service.OrderService;
import com.wangyx.sell.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author xxxx
 * @Date 2020/3/1 15:01
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1582728922018213042");

        pushMessageService.orderStatus(orderDTO);
    }
}
