package com.example.aop;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by wangshuai on 2019/7/22.
 */
@Configurable
@AutoConfigureOrder
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ConditionalOnClass(LogAspect.class)
@ConditionalOnMissingBean(LogAspect.class)
public class LogAspectConfiguration {
    @Bean
    public LogAspect getClogAspect(){
        return new LogAspect();
    }
}
