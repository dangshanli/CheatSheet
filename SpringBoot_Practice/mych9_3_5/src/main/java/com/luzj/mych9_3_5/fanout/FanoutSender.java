package com.luzj.mych9_3_5.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luzj
 * @description:
 * @date 2018/8/15
 */
@Component
public class FanoutSender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendFan(String message){
        rabbitTemplate.convertAndSend("fanout.a","","<<<"+message+">>>");
    }


}
