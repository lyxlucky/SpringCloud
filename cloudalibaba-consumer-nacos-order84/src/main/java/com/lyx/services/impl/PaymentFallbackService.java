package com.lyx.services.impl;

import com.lyx.entity.CommonResults;
import com.lyx.entity.Payment;
import com.lyx.services.PaymentServices;
import org.springframework.stereotype.Component;

/**
 * @author liao 2021/10/3
 */
@Component
public class PaymentFallbackService implements PaymentServices {
    @Override
    public CommonResults<Payment> paymentSQL(Long id) {
        return new CommonResults<>(444,"服务降级返回----paymentfallbackservice");
    }
}
