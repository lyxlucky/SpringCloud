package com.lyx.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lyx.entity.CommonResults;

/**
 * @author liao 2021/10/2
 */
public class CustomerBlockHandler {

    public static CommonResults handlerException1(BlockException be){
        return new CommonResults(444,"按客户自定义,Global handlerException-----1");
    }

    public static CommonResults handlerException2(BlockException be){
        return new CommonResults(444,"按客户自定义,Global handlerException-----2");
    }

}
