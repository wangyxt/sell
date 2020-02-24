package com.wangyx.sell.service.impl;

import com.wangyx.sell.dto.CartDTO;
import com.wangyx.sell.dto.OrderDTO;
import com.wangyx.sell.entity.OrderDetailEntity;
import com.wangyx.sell.entity.OrderMasterEntity;
import com.wangyx.sell.entity.ProductInfoEntity;
import com.wangyx.sell.enums.OrderStatusEnum;
import com.wangyx.sell.enums.PayStatusEnum;
import com.wangyx.sell.enums.ResultEnum;
import com.wangyx.sell.exceptions.SellException;
import com.wangyx.sell.repository.OrderDetailRepository;
import com.wangyx.sell.repository.OrderMasterRepository;
import com.wangyx.sell.service.OrderService;
import com.wangyx.sell.service.ProductService;
import com.wangyx.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:19
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    
    @Autowired
    private ProductService productService;
    
    @Override
    @Transactional(rollbackOn = Exception.class)
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //1.查询商品（数量，价格）
        for (OrderDetailEntity orderDetail : orderDTO.getOrderDetailList()){
            ProductInfoEntity productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                        .add(orderAmount);
            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);
        }

        //3.写入订单数据库（OrderMaster，OrderDetail）
        OrderMasterEntity orderMaster = new OrderMasterEntity();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //4.扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(),e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseSotck(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
