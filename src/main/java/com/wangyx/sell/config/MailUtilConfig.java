package com.wangyx.sell.config;

import com.wangyx.sell.utils.MailUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailUtilConfig {

    @Bean
    public MailUtil mathUtil(){
        MailUtil mailUtil = new MailUtil();
        return mailUtil;
    }
}
