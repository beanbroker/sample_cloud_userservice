package com.beanbroker.user.controller;


import com.beanbroker.user.domain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    final
    HttpServletRequest request;

    public UserController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping
    public UserInfo getUserInfo(){
        getHeadersInfo(request);

        logger.info("start to get user Info");
        return new UserInfo("beanbroker", 32);

    }



    @GetMapping("/test")
    public UserInfo testUserInfo(){
        getHeadersInfo(request);

        logger.info("start to get user Info");
        return new UserInfo("test", 32);

    }


    private Map<String, String> getHeadersInfo(HttpServletRequest request) {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + ":" + value);
            map.put(key, value);
        }

        return map;
    }
}
