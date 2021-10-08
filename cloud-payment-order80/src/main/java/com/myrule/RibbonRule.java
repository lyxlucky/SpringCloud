package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liao 2021/9/25
 */
@Configuration
public class RibbonRule {

    @Bean
    public IRule myRule(){
        return new RoundRobinRule();
    }

}
