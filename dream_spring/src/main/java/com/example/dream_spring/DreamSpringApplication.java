package com.example.dream_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
//@ComponentScan(basePackages = "com.example.dream_spring.mapper")
//@ComponentScan(basePackages = {"com.asiainfo.pm.admin.dao.impl","com.asiainfo.pm.admin.dao"})
public class DreamSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DreamSpringApplication.class, args);
    }

}
