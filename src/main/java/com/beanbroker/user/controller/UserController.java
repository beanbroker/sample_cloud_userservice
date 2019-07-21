package com.beanbroker.user.controller;


import com.beanbroker.user.domain.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {



    @GetMapping
    public UserInfo getUserInfo(){

        return new UserInfo("beanbroker", 32);

    }
}
