package com.example.demo.controller;

import com.example.aop.LogAnnotation;
import com.example.demo.domain.User;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wangshuai
 * @date 2019/5/23
 */
@RestController
public class UserController {

    @Autowired
    private TestService testService;

    @LogAnnotation(actionName = "123",description = "456")
    @GetMapping("/save")
    public Object saveUser(@RequestParam String name){
        User u = new User();
        u.setName(name);
        return testService.save(u);
    }

    @GetMapping("/test")
    public String test(){
        return "jenkins ok!";
    }
}
