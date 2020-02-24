package com.wangyx.sell.converter;

import com.wangyx.sell.dto.OrderDTO;
import com.wangyx.sell.entity.OrderMasterEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMasterEntity orderMasterEntity){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMasterEntity,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMasterEntity> orderMasterList){
        return orderMasterList.stream().map(e ->
            convert(e)
        ).collect(Collectors.toList());
    }
}
