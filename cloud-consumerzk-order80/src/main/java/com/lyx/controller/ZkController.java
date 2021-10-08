package com.lyx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liao 2021/9/24
 */
@RestController
@Slf4j
public class ZkController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){
        String results = restTemplate.getForObject(INVOKE_URL + "/server/port", String.class);
        System.out.println("results = " + results);
        return results;
    };

}
