package com.wangyx.sell.repository;

import com.wangyx.sell.entity.ProductCategoryEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategoryEntity one = repository.findOne(1);
        log.info("获取到{}",one);
    }

    @Test
    @Transactional
    public void update(){
//        ProductCategoryEntity entity = new ProductCategoryEntity(2,"四川菜",2);
        ProductCategoryEntity entity = repository.findOne(2);
        entity.setCategoryType(5);
        ProductCategoryEntity result = repository.save(entity);
        Assert.assertNotNull(result);
//        log.info("修改为:{}",entity);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);

        List<ProductCategoryEntity> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result);
    }
}
