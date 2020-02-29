package com.wangyx.sell.service.impl;

import com.wangyx.sell.entity.ProductCategoryEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryServiceImpl service;

    @Test
    public void findOne() {
        ProductCategoryEntity one = service.findOne(1);
//        Assert.assertEquals(1,one.getCategoryId());
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByCategoryTypeIn() {
    }

    @Test
    public void save() {
    }
}
