package com.lyx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liao 2021/9/27
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String port;

    @Value("${config.info}")
    private String config;

    @GetMapping("/config")
    public String getConfig(){
        return "serverPort"+port+"\t"+"configInfo"+config;
    }

}
