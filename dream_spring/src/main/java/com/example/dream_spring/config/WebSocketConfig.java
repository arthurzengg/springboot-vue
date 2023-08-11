package com.example.dream_spring.config;

import com.example.dream_spring.service.WebSocketServer;
import com.example.dream_spring.utils.SpringContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author Arthur Zeng
 * @description 开启WebSocket
 **/
@Configuration
@EnableScheduling
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Scheduled(fixedRate=15*1000)
    public void configureTasks(){
        //  每15秒发送一次心跳
        //  避免 org.apache.tomcat.util.net.NioEndpoint$NioSocketWrapper.fillReadBuffer 错误
        SpringContextHolder.getBean(WebSocketServer.class).groupMessage("this is the heartbeat message", null);
    }
}
