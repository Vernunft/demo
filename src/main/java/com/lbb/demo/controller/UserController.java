package com.lbb.demo.controller;

import com.lbb.demo.entity.User;
import com.lbb.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.annotation.Resource;

/**
 * @author lbb
 * @date 2020/9/4 下午2:39
 */
@RestController
@RequestMapping("user")
public class UserController {

//    @Resource
//    UserService userService;
//
//    @GetMapping("list")
//    public List<User> getUsers() {
//        return userService.getUsers();
//    }
}
