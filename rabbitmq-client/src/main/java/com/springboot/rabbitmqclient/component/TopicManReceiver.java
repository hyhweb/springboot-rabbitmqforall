package com.springboot.rabbitmqclient.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Create by hyhweb on 2020/9/14 11:53
 */
@Component
@RabbitListener(queues = "topic.man") //监听队列名称为：topic.man
public class TopicManReceiver {
    @RabbitHandler
    public void process(Map message) {
        System.out.println("TopicManReceiver消费者收到消息:"+message.toString());
    }
}
