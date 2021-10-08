package com.lyx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lyx.entity.CommonResults;
import com.lyx.entity.Payment;
import com.lyx.services.PaymentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liao 2021/10/3
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICES_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") // 什么都没有配置，返回默认的sentinel提示
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")//blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",exceptionsToIgnore = {
            IllegalArgumentException.class
    })
    public CommonResults<Payment> fallback(@PathVariable Long id){
        CommonResults object = restTemplate.getForObject(SERVICES_URL + "/paymentSQL/" + id, CommonResults.class, id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,||非法参数异常");
        }else if(object.getData() == null){
            throw new NullPointerException("该id没有对应记录");
        }
        return object;
    }
    //fallback例子
    public CommonResults<Payment> handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id, null);
        return new CommonResults<>(444,"沟底异常handlerFallback"+e.getMessage(),payment);
    }

    //blockHandler例子
    public CommonResults<Payment> blockHandler(@PathVariable Long id, BlockException be){
        Payment payment = new Payment(id, null);
        return new CommonResults<>(445,"blockHandler-sentinel限流，无此流水：blockexception"+be.getMessage(),payment);
    }

    //========openfiegn=======

    @Autowired
    private PaymentServices services;

    @GetMapping("/paymentSQL/{id}")
    public CommonResults<Payment> paymentSQL(@PathVariable("id") Long id){
        return services.paymentSQL(id);
    }

}
