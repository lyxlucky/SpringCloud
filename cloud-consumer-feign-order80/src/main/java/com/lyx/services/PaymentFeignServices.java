package com.lyx.services;

import com.lyx.entity.CommonResults;
import com.lyx.entity.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liao 2021/9/25
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignServices {

    @GetMapping("/payment/get/{id}")
    public CommonResults<Payment> getParamById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    public String getPaymentFeignTimeout();

    @DeleteMapping("/payment/test")
    public String test();

}
