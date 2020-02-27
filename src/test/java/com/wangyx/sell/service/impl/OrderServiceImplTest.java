package com.wangyx.sell.service.impl;

import com.wangyx.sell.dto.OrderDTO;
import com.wangyx.sell.entity.OrderDetailEntity;
import com.wangyx.sell.enums.OrderStatusEnum;
import com.wangyx.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:59
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1582470844309108055";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("王爱吃");
        orderDTO.setBuyerAddress("杭州西湖");
        orderDTO.setBuyerPhone("13354546667");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetailEntity> orderDetailLists = new ArrayList<>();
        OrderDetailEntity o1 = new OrderDetailEntity();
        o1.setProductId("123");
        o1.setProductQuantity(1);

        OrderDetailEntity o2 = new OrderDetailEntity();
        o2.setProductId("234");
        o2.setProductQuantity(1);
        orderDetailLists.add(o1);
        orderDetailLists.add(o2);

        orderDTO.setOrderDetailList(orderDetailLists);

        OrderDTO result = orderService.create(orderDTO);

        log.info("【创建订单】 result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {

        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】 result={}",orderDTO);
        Assert.assertEquals(ORDER_ID,orderDTO.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void List(){
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
//        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
        Assert.assertTrue("查询所有的订单列表",orderDTOPage.getTotalElements() > 0);
    }
}
