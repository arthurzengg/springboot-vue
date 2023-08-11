package com.example.dream_spring.service;

import com.example.dream_spring.service.dto.OpenAiRequest;

/**
 * @author Arthur Zeng
 * @description OpenAi服务接口
 * @date 2023-08-11
 **/
public interface OpenAiService {

    /**
     * 问答，绘画
     *
     * @param openAiDto       /
     * @param webSocketServer /
     */
    void communicate(OpenAiRequest openAiDto, WebSocketServer webSocketServer) throws Exception;
}
