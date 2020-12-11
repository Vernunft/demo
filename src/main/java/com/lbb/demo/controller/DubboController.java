package com.lbb.demo.controller;

import com.lbb.demo.consume.ConsumeDubbo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author lbb
 * @date 2020/12/10 6:19 下午
 */
@RestController
@RequestMapping("/dubbo/")
public class DubboController {

    @Resource
    private ConsumeDubbo consumeDubbo;

    @PostMapping("test")
    public void testDubbo() {
        consumeDubbo.consume();
    }
}
