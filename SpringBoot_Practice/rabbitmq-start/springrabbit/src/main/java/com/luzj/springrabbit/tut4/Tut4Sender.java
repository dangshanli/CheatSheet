package com.luzj.springrabbit.tut4;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author: luzj
 * @date: 2018-11-29
 * @description:
 */
public class Tut4Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange direct;

    private int index;
    private int count;

    private final String[] keys = {"orange", "black", "green"};

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sender() {
        StringBuilder builder = new StringBuilder("Hello to ");
        if (++index == 3)
            index = 0;

        String key = keys[index];
        builder.append(key).append(" ");
        builder.append(Integer.toString(++count));
        String message = builder.toString();
        template.convertAndSend(direct.getName(), key, message);
        System.out.println(" [x] Sent '" + message + "'");
    }

}
