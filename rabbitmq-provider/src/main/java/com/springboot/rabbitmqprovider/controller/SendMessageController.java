package com.springboot.rabbitmqprovider.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Create by hyhweb on 2020/9/14 10:01
 */
@RestController
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage(@RequestParam String message) {
        String messageId = String.valueOf(UUID.randomUUID());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("messageId", messageId);
        map.put("message", "test send message,hello " + message);
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "send successs";
    }

    @GetMapping("/sendTopicMessage1")
    public String sendTopicMessage1(@RequestParam String message) {
        String messageId = String.valueOf(rabbitTemplate.getUUID());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("messageId", messageId);
        map.put("message", "test send message,hello man " + message);

        rabbitTemplate.convertAndSend("topicExchange", "topic.man", map);
        return "send successs";
    }

    @GetMapping("/sendTopicMessage2")
    public String sendTopicMessage2(@RequestParam String message) {
        String messageId = String.valueOf(rabbitTemplate.getUUID());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("messageId", messageId);
        map.put("message", "test send message,hello woman " + message);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", map);
        return "send successs";
    }

    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage(@RequestParam String message) {
        String messageId = String.valueOf(rabbitTemplate.getUUID());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("messageId", messageId);
        map.put("message", "test send message,hello fanoutExchange " + message);
        rabbitTemplate.convertAndSend("fanoutExchange", null, map);
        return "send success";
    }
}
