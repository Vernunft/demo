package com.lbb.demo.controller;

import com.lbb.demo.mq.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import javax.annotation.Resource;

/**
 * @author lbb
 * @date 2020/9/4 下午4:11
 */
@RestController
@RequestMapping("produce")
public class ProduceController {

    @Resource
    RocketMQTemplate rocketMQTemplate;

    @PostMapping("send")
    public void sendMessage() {
        Message message = Message.builder().id(UUID.randomUUID().toString()).message("send " +
                "message").build();

        rocketMQTemplate.convertAndSend("test-send", message);
        System.out.println("生产者发送消息成功，消息内容" + message.toString());
    }
}
