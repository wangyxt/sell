package com.wangyx.sell.service.impl;

import com.wangyx.sell.entity.SellerInfo;
import com.wangyx.sell.repository.SellerInfoRepository;
import com.wangyx.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xxxx
 * @Date 2020/3/1 10:53
 * @Version 1.0
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openId) {
        return repository.findByOpenid(openId);
    }
}
