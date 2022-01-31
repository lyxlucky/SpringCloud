package com.lyx.controller;

import com.lyx.entity.CommonResults;
import com.lyx.entity.Payment;
import com.lyx.services.PaymentServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * @author liao 2021/1/31
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentServices paymentServices;

    @PostMapping("/payment/add")
    public CommonResults add(@RequestBody Payment payment){
        Integer add = paymentServices.add(payment);
        log.info("插入结果"+add+"serverPort "+serverPort);
        if(add>0){
            return new CommonResults(200,"success",add);
        }else{
            return new CommonResults(444,"error",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResults<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment add = paymentServices.getPaymentById(id);
        log.info("插入结果[]",add);
        if(add != null){
            return new CommonResults(200,"success serverPort"+serverPort,add);
        }else{
            return new CommonResults(444,"error no such id"+id,null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentFeignTimeout(){
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String getConfig(){
        return "hi i am paymentzipkin server fall back ";
    }

    @DeleteMapping("/payment/test")
    public String test(){
        return serverPort;
    }

}
