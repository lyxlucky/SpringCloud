package com.lyx.service;

import org.springframework.stereotype.Component;

/**
 * @author liao 2021/9/26
 */
@Component
public class PaymentFallbackServices implements PaymentHystrixServices{
    @Override
    public String PaymentInfo_ok(Integer id) {
        return "----PaymentFallbackServices----payment-OK---";
    }

    @Override
    public String PaymentInfo_Timeout(Integer id) {
        return "----PaymentFallbackServices----payment-TimeOut---";
    }
}
