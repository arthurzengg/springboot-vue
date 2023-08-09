package com.example.dream_spring.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class getProvince {

    public String getProvince_(String ip){
        //设置api的url
        String url = "https://ip.useragentinfo.com/json?ip=" + ip;

        RestTemplate template = new RestTemplate();

        //发起一个HTTP GET请求，获取指定URL的响应实体，String.class表示要获取的响应实体的类型是字符串类型。
        ResponseEntity<String> response =template.getForEntity(url,String.class);

        //将Spring类型转换为json类型
        JSONObject json = JSON.parseObject(response.getBody());
        //取出json中的数据
        String province = json.getString("province");

        return province;
    }
}
