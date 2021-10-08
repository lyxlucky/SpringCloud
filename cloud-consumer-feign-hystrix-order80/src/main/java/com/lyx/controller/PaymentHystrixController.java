package com.lyx.controller;

import com.lyx.service.PaymentHystrixServices;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liao 2021/9/25
 */
@RestController
@DefaultProperties(defaultFallback = "PaymentInfo_GlobalHandler")
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixServices services;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable Integer id){
        return services.PaymentInfo_ok(id);
    }

    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String PaymentInfo_Timeout(@PathVariable Integer id){
        return services.PaymentInfo_Timeout(id);
    }

    public String PaymentInfo_TimeoutHandler(){
        return "我是消费者80，对方支付系统繁忙，请10秒钟后再试或者自己运行出错请检查自己^_^";
    }
    public String PaymentInfo_GlobalHandler(){
        return "我是消费者80，全局异常";
    }

}
