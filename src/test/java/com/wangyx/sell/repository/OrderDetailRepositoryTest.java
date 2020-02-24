package com.wangyx.sell.repository;

import com.wangyx.sell.entity.OrderDetailEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:05
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save(){
        OrderDetailEntity orderDetail = new OrderDetailEntity();
        orderDetail.setDetailId("1897854");
        orderDetail.setOrderId("1123656");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("12323");
        orderDetail.setProductName("大闸蟹");
        orderDetail.setProductPrice(new BigDecimal(1.2));
        orderDetail.setProductQuantity(2);

        OrderDetailEntity result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetailEntity> orderDetailList = repository.findByOrderId("11233");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}
