package com.wangyx.sell.service;

import com.wangyx.sell.entity.SellerInfo;

/**
 * @Author xxxx
 * @Date 2020/3/1 10:52
 * @Version 1.0
 */
public interface SellerService {

    /**
     * 通过openid查询
     * @param openId
     * @return
     */
    SellerInfo findSellerInfoByOpenId(String openId);
}
