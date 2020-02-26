package com.wangyx.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.wangyx.sell.dto.OrderDTO;
import com.wangyx.sell.enums.ResultEnum;
import com.wangyx.sell.exceptions.SellException;
import com.wangyx.sell.service.OrderService;
import com.wangyx.sell.service.PayService;
import com.wangyx.sell.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId")String orderId,
                               @RequestParam("returnUrl")String returnUrl) throws UnsupportedEncodingException {
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2. 发起支付
        PayResponse payResponse = payService.create(orderDTO);

        Map map = new HashMap<String,Object>();
        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl.startsWith("http://") ? returnUrl : URLEncoder.encode(returnUrl, "utf-8"));

        return new ModelAndView("pay/create", map);
    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        PayResponse payResponse = payService.notify(notifyData);

        //返回给微信结果
        return new ModelAndView("pay/sucess");
    }
}
