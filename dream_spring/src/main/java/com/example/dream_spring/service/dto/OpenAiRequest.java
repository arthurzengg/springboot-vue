package com.example.dream_spring.service.dto;

import lombok.Data;

/**
 * @author Arthur Zeng
 * @description OpenAi接口请求参数
 * @date 2023-08-11
 **/
@Data
public class OpenAiRequest {

    /**
     * 请求类型：1文本，2图片，3余额
     */
    private Integer id;

    /**
     * 连续对话
     */
    private Integer keep;

    /**
     * 问题
     */
    private String text;

    /**
     * 连续对话的问题
     */
    private String keepText;

    /**
     * apiKey
     */
    private String apikey;
}