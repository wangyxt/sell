package com.wangyx.sell.repository;


import com.wangyx.sell.entity.OrderMasterEntity;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Author xxxx
 * @Date 2020/2/23 21:51
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "123123";

    @Test
    public void saveTest(){
        OrderMasterEntity orderMasterEntity = new OrderMasterEntity();
        orderMasterEntity.setOrderId("211469");
        orderMasterEntity.setBuyerName("沙僧");
        orderMasterEntity.setBuyerPhone("13303546688");
        orderMasterEntity.setBuyerAddress("北京市南城");
        orderMasterEntity.setBuyerOpenid(OPENID);
        orderMasterEntity.setOrderAmount(new BigDecimal("75.50"));

        OrderMasterEntity result = repository.save(orderMasterEntity);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0,1);

        Page<OrderMasterEntity> result = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}
