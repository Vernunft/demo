package com.lbb.demo.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author lbb
 * @date 2020/9/4 下午4:31
 */
@Service
@RocketMQMessageListener(consumerGroup = "demo-group", topic = "test-send")
public class TestSendConsumer implements RocketMQListener<Message> {
    @Override
    public void onMessage(Message message) {
        System.out.println("消费者接收到消息" + message.toString());
    }
}
