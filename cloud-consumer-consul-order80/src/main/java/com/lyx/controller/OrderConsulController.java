package com.lyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author liao 2021/9/24
 */
@RestController
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo(){
        String results = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        System.out.println("results = " + results);
        return results;
    };

    @GetMapping("/test")
    public String test(){
        return "Hello,World";
    }



}
