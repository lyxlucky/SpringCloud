package com.lyx.services.impl;

import cn.hutool.core.util.IdUtil;
import com.lyx.services.MessageServices;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @author liao 2021/9/29
 */
@EnableBinding(Source.class)
public class MessageServicesImpl implements MessageServices {

    @Resource
    private MessageChannel output;


    @Override
    public String send() {

        String serial = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial = " + serial);
        return null;
    }
}
