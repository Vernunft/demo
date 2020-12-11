package com.lbb.demo.controller;

import com.lbb.demo.redis.RedisUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author lbb
 * @date 2020/12/8 4:19 下午
 */
@RestController
@RequestMapping("/redis/")
public class RedisController {

    @Resource
    private RedisUtils redisUtils;

    @PostMapping("set")
    public void set() {
        redisUtils.set("test", "testSet");
        System.out.println(redisUtils.get("test"));
    }
}