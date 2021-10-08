package com.lyx.controller;

import com.lyx.entity.CommonResults;
import com.lyx.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liao 2021/1/31
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/add")
    public CommonResults<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResults.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResults getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResults.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResults getPaymentForEntity(@PathVariable Integer id){
        ResponseEntity<CommonResults> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResults.class);

        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommonResults(444,"操作超时");
        }
    }

    @GetMapping("/payment/consumer/zipkin")
    public String paymentZipkin(){
        String forObject = restTemplate.getForObject("http://localhost:8001/" + "payment/zipkin", String.class);
        return forObject;
    }


}
