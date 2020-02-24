package com.wangyx.sell.service.impl;

import com.wangyx.sell.entity.ProductInfoEntity;
import com.wangyx.sell.enums.ProductStatusEnum;
import com.wangyx.sell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfoEntity productInfo = productService.findOne("123");
        Assert.assertEquals("123",productInfo.getProductId());
    }

    @Test
    public void findAll() {
        List<ProductInfoEntity> upList = productService.findUpAll();
        Assert.assertNotEquals(0,upList.size());
    }

    @Test
    public void testFindAll() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfoEntity> pageList = productService.findAll(pageRequest);
        System.out.println(pageList.getTotalElements());
        Assert.assertEquals(2,pageList.getSize());
    }

    @Test
    public void save() {
        ProductInfoEntity productInfoEntity = new ProductInfoEntity();
        productInfoEntity.setProductId("234");
        productInfoEntity.setProductName("水煮鱼");
        productInfoEntity.setProductPrice(new BigDecimal("45.50"));
        productInfoEntity.setProductStock(5);
        productInfoEntity.setProductIcon("http://xxxxx.jpg");
        productInfoEntity.setProductDescription("正宗四川水煮鱼");
        productInfoEntity.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfoEntity.setCategoryType(2);

        ProductInfoEntity save = productService.save(productInfoEntity);
        Assert.assertNotNull(save);
    }
}
