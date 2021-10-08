package com.lyx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lyx.entity.CommonResults;
import com.lyx.entity.Payment;
import com.lyx.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liao 2021/10/2
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResults byResource(){
        return new CommonResults(200,"按资源名称限流测试ok",new Payment(2020L,"serival001"));
    }

    public CommonResults handleException(BlockException ex){
        return new CommonResults(444,ex.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResults byUrl(){
        return new CommonResults(200,"按url测试限流ok",new Payment(2020L,"serival 2021"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResults customerBlockHandler(){
        return new CommonResults(200,"按客户自定义限流",new Payment(2020L,"serival 2021"));
    }

}
