package com.wangyx.sell.service.impl;

import com.wangyx.sell.entity.SellerInfo;
import com.wangyx.sell.service.SellerService;
import com.wangyx.sell.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author xxxx
 * @Date 2020/3/1 10:54
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerServiceImplTest {

    private static final String openid = "abc";

    @Autowired
    private SellerService sellerService;

    @Test
    public void findSellerInfoByOpenId() {
        SellerInfo abc = sellerService.findSellerInfoByOpenId(openid);
        log.info("查询出:{}", JsonUtil.toJson(abc));
        Assert.assertNotNull(abc);
    }
}
