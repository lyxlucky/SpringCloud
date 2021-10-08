package com.lyx.services;

import com.lyx.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author liao 2021/1/31
 */
public interface PaymentServices {
    /**
     * add user's method
     * @param payMent
     * @return
     */
    public Integer add(Payment payMent);

    /**
     * get payment by id
     * @param id
     * @return
     */
    public Payment getPaymentById(Long id);
}
