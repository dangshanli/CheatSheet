package com.luzj.mych9_3_5.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luzj
 * @description:
 * @date 2018/8/15
 */
@Component
public class TopicSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMing(){
        String message = "嘿，我是ming!!!";
        rabbitTemplate.convertAndSend("exchange","topic.ming",message);
    }

    public void sendAllTopic(){
        String message = "嘿，我是all topics";
        rabbitTemplate.convertAndSend("exchange","topic.#",message);
    }




}
