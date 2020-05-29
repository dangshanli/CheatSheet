package com.luzj.mych9_3_5;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luzj
 * @description:
 * @date 2018/8/14
 */
@Component
public class RabbitSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;//rabbit提供的访问客户端模板

    public void send() {//一对一发送
        rabbitTemplate.convertAndSend("my-queue", "来自rabbitMQ的问候");//向队列发送消息
    }

    public void sendToKaras(String message){//一对多发送
        String text = "[karas],<<<<<<<< "+message+" >>>>>>>";
        rabbitTemplate.convertAndSend("karas",text);
    }

    public void sendToFish(User user){//发送对象
        rabbitTemplate.convertAndSend("fish",user);
    }


}
