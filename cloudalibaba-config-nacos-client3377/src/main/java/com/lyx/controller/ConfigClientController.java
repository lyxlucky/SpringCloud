package com.lyx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liao 2021/9/29
 */
@RestController
//动态刷新
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String config;

    @GetMapping("/getConfig")
    public String getConfig(){
        return config;
    }

}
