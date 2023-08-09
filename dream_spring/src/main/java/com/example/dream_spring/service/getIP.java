package com.example.dream_spring.service;

import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getIP {

    @Bean
    public String getIP_(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html;charset=utf-8");

        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */

        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        return getIpAddr(request);
    }

    public String getIpAddr(HttpServletRequest request) {
        //获取请求头"x-forwarded-for"对应的value
        String ip = request.getHeader("x-forwarded-for");
        //如果获取的ip值为空
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            //则获取请求头"Proxy-Client-IP"对应的value
            ip = request.getHeader("Proxy-Client-IP");
        }
        //如果获取的ip值仍为空
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            //则获取请求头"WL-Proxy-Client-IP"对应的value
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        //如果以上方式获取的ip值都为空
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            //则直接获取ip地址
            ip = request.getRemoteAddr();
        }
        //返回ip地址
        return ip;
    }
}
