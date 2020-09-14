package com.springboot.rabbitmqclient.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Create by hyhweb on 2020/9/14 10:47
 */
/*
@Component
@RabbitListener(queues = "TestDirectQueue") //监听的队列名称:TestDirectQueue
public class DirectReceiverNew {
    @RabbitHandler
    public void process(Map message) {
        System.out.println("第二个DirectReceiver消费者收到消息："+message.toString());
    }
}
*/
