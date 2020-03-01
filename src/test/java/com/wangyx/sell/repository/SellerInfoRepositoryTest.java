package com.wangyx.sell.repository;

import com.wangyx.sell.entity.SellerInfo;
import com.wangyx.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author xxxx
 * @Date 2020/3/1 10:47
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setOpenid("abc");
        sellerInfo.setPassword("123456");
        sellerInfo.setUsername("掌声");
        SellerInfo save = repository.save(sellerInfo);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOpenid(){
        SellerInfo re = repository.findByOpenid("abc");
        Assert.assertNotNull(re);
    }
}
