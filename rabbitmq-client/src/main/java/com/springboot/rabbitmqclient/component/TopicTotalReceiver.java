package com.springboot.rabbitmqclient.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Create by hyhweb on 2020/9/14 11:58
 */
@Component
@RabbitListener(queues = "topic.woman")
public class TopicTotalReceiver {
    @RabbitHandler
    public void process(Map message) {
        System.out.println("TopicTotalReceiver消费者收到消息："+message.toString());
    }
}
