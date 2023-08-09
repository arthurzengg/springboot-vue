package com.example.dream_spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getTime {

    public String getTime_(){

        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间，也可使用当前时间戳
        String date = df.format(new Date());

        return date;
    }
}
