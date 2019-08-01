package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wangshuai
 * @date 2019/5/23
 */
@RestController
public class UserController {

    @GetMapping("/test")
    public String test(){
        return "provider ok!";
    }
}
