package com.lyx.controller;

import com.lyx.entity.CommonResults;
import com.lyx.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liao 2021/10/3
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    public static Map<Long,Payment> map = new HashMap<>();

    static {
        map.put(1L,new Payment(1L,"14263swdfst4574sdf636"));
        map.put(2L,new Payment(2L,"4657sgr8568er64fhrt74"));
        map.put(3L,new Payment(3L,"09rtyre6f757e86544212"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResults<Payment> PaymentSQL(@PathVariable Long id){
        Payment payment = map.get(id);
        return new CommonResults<Payment>(200,"from mysql server port "+port,payment);
    }

}
