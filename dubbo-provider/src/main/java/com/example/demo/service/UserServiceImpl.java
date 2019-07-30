package com.example.demo.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.domain.User;
import com.example.api.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author wangshuai
 */
@Service
@Component
public class UserServiceImpl implements UserService {

    @Override
    public User saveUser(User user) {
//        int[] tt= {1,2,3,4,5};
//        int sum = Arrays.stream(tt).boxed().mapToInt(Integer::intValue).sum();
//        System.out.println(sum);


        user.setId(1);
//        user.setName("shine");
        System.out.println("saveUser:" + user.toString());
        return user;
    }
}
