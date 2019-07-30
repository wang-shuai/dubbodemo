package com.example.demo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.aop.LogAnnotation;
import com.example.api.domain.User;
import com.example.api.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by wangshuai on 2019/5/23.
 */
@Component
public class TestService {
    @Reference
    UserService userService;

    @LogAnnotation(actionName = "service",description = "server test")
    public User save(User user){
        System.out.println("invoke dubbo provider");

        if (userService == null) {
            System.out.println("@reference  userService is null");
        }

        return userService.saveUser(user);
    }
}
