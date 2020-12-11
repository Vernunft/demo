package com.lbb.demo.controller;

import com.lbb.demo.common.SpringContextUtils;
import com.lbb.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("test")
    public void test() {
        UserService userService = SpringContextUtils.getBeanByName("UserServiceImpl", UserService.class);
        userService.getUsers();
    }
}
