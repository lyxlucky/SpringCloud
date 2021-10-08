package com.lyx.services.Impl;

import com.lyx.dao.PaymentDao;
import com.lyx.entity.Payment;
import com.lyx.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liao 2021/1/31
 */
@Service
public class PaymentServicesImpl implements PaymentServices {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Integer add(Payment payMent) {
        return paymentDao.add(payMent);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
