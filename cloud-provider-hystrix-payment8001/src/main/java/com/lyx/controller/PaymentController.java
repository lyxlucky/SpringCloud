package com.lyx.controller;

import com.lyx.services.PaymentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author liao 2021/9/25
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServices services;

    @Value(value = "${server.port}")
    private String serverport;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable Integer id){
        String s = services.PaymentInfo_ok(id);
        return s;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String PaymentInfo_Timeout(@PathVariable Integer id){
        log.info(id+"PaymentInfo_Timeout method has execute");
        return services.PaymentInfo_Timeout(id);
    }

    @GetMapping("/payment/hystrxi/circuit/{id}")
    public String circuit(@PathVariable Integer id){
        log.info("result");
        return services.paymentCircuitBreaker(id);
    }

}
