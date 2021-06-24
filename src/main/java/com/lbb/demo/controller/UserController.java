package com.lbb.demo.controller;

import com.lbb.demo.dao.UserMapper;
import com.lbb.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import javax.annotation.Resource;

/**
 * @author lbb
 * @date 2020/9/4 下午2:39
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @PostMapping("/user/save")
    public String save() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setCityId(2 % 2 == 0 ? 1 : 2);
            user.setCreateTime(new Date());
            user.setSex(i % 2 == 0 ? 1 : 2);
            user.setPhone("11111111" + i);
            user.setEmail("xxxxx");
            user.setCreateTime(new Date());
            user.setPassword("eeeeeeeeeeee");
            userMapper.save(user);
        }
        return "success";
    }

    @GetMapping("/user/get/{id}")
    public User get(@PathVariable Long id) {
        User user = userMapper.get(id);
        System.out.println(user.getId());
        return user;
    }

}

