package com.luzj.springrabbit.tut5;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author: luzj
 * @date: 2018-11-29
 * @description: 消息生产者，使用template这种方便的工具
 */
public class Tut5Sender {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private TopicExchange topic;

    private int index;
    private int count;

    private final String[] keys = {"quick.orange.rabbit",
            "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox"};

    @Scheduled(fixedDelay = 1000,initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello to ");
        if (++index == keys.length)
            index = 0;

        String key = keys[index];
        builder.append(key).append(' ');
        builder.append(Integer.toString(++count));
        String message = builder.toString();
        template.convertAndSend(topic.getName(), key, message);
        System.out.println(" [x] Sent '" + message + "'");
    }


}
