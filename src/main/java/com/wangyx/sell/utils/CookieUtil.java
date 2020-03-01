package com.wangyx.sell.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * cookie工具类
 * @Author xxxx
 * @Date 2020/3/1 13:54
 * @Version 1.0
 */
public class CookieUtil {

    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(7200);
        response.addCookie(cookie);
    }


    public static Cookie get(HttpServletRequest request,
                           String name){
        Map<String, Cookie> cookieMap = readCookie(request);
        if (cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else {
            return null;
        }
    }

    private static Map<String,Cookie> readCookie(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }
}
