package com.wangyx.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/weixin")
public class WeixinController {



    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("code={}",code);
        log.info("进入auth方法。。。");
        String r = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx4b0594326d23c9e2&secret=a932a6bb93bc8a229d50c566984e53b6&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(r, String.class);
        log.info("response={}",response);
    }
}
