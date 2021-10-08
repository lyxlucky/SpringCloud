package com.lyx.services;

import com.lyx.entity.CommonResults;
import com.lyx.entity.Payment;
import com.lyx.services.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liao 2021/10/3
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentServices {
    @GetMapping("/paymentSQL/{id}")
    public CommonResults<Payment> paymentSQL(@PathVariable("id") Long id);
}
