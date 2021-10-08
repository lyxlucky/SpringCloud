package com.lyx.dao;

import com.lyx.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liao 2021/1/31
 */
@Repository
public interface PaymentDao {
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
    public Payment getPaymentById(@Param("id") Long id);
}
