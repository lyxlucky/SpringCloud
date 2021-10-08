package com.lyx.services;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author liao 2021/9/25
 */
@Service
public class PaymentServices {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String PaymentInfo_ok(Integer id){
        return "线程池: "+Thread.currentThread().getName()+"  PaymentInfo_ok  "+id+"\t"+"O(∩_∩)O哈哈~";
    }

    /**
     * 模拟超时
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "PaymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String PaymentInfo_Timeout(Integer id){
        int sec = 5;
        int age = 10 /0;
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+"  PaymentInfo_Timeout  "+id+"\t"+"O(∩_∩)O哈哈~"+"耗时:";
    }

    public String PaymentInfo_TimeoutHandler(Integer id){
        int sec = 5;
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+"  PaymentInfo_TimeoutHandler  "+id+"\t"+"o(╥﹏╥)o"+"耗时:"+sec+"秒";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败达到多少次开启熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号:"+uuid;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数,请稍后再试";
    }

}
