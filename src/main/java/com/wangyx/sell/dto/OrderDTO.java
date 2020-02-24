package com.wangyx.sell.dto;

import com.wangyx.sell.entity.OrderDetailEntity;
import com.wangyx.sell.enums.OrderStatusEnum;
import com.wangyx.sell.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:16
 * @Version 1.0
 */
@Data
public class OrderDTO {

    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    private Date createTime;
    private Date updateTime;

    List<OrderDetailEntity> orderDetailList;
}
