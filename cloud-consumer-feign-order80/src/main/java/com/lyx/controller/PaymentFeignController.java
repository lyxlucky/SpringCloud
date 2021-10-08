package com.lyx.controller;

import com.lyx.entity.CommonResults;
import com.lyx.services.PaymentFeignServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liao 2021/9/25
 */
@RestController
public class PaymentFeignController {

    @Autowired
    private PaymentFeignServices paymentFeignServices;

    @GetMapping("/consumer/get/{id}")
    public CommonResults get(@PathVariable Long id){
        return paymentFeignServices.getParamById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String getPaymentFeignTimeout(){
        return paymentFeignServices.getPaymentFeignTimeout();
    }

}
