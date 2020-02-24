package com.wangyx.sell.utils;

import java.util.Random;

/**
 * @Author xxxx
 * @Date 2020/2/23 22:36
 * @Version 1.0
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
