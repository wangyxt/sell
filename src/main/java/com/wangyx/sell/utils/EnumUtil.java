package com.wangyx.sell.utils;

import com.wangyx.sell.enums.CodeEnum;

/**
 * @Author xxxx
 * @Date 2020/2/27 20:41
 * @Version 1.0
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each: enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
