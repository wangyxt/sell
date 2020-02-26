package com.wangyx.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wangyx.sell.dto.OrderDTO;
import com.wangyx.sell.entity.OrderDetailEntity;
import com.wangyx.sell.enums.ResultEnum;
import com.wangyx.sell.exceptions.SellException;
import com.wangyx.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {

    private static final String TESTOPENID = "oTgZpwUWEZITJkqJs4s153yWOJ0M";

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(TESTOPENID);

        List<OrderDetailEntity> orderDetailEntityList;
        try {
            orderDetailEntityList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetailEntity>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailEntityList);
        return orderDTO;
    }

}
