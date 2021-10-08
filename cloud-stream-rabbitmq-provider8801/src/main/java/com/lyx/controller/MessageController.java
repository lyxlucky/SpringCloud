package com.lyx.controller;

import com.lyx.services.MessageServices;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liao 2021/9/29
 */
@RestController
public class MessageController {

    @Resource
    private MessageServices services;

    @GetMapping("/sendMessage")
    public String send(){
        return services.send();
    }

}
