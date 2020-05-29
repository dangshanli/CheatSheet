package com.luzj.mych9_3_4.mqpattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author luzj
 * @description: 消息消费者
 * @date 2018/8/13
 */
@Component
public class JmsConsumer {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 消费方法，监听  `my-destination`  的消息
     * @param message
     */
    @JmsListener(destination = "my-destination")
    public void receive(String message) {
        System.err.println("接受的消息是：[my-destination]"+message);
    }

    /**
     * 可以对接多个消费者
     * @param message
     */
    @JmsListener(destination = "my-karas")
    public void  solve(String message){
        System.err.println("接受的消息是：[my-karas]"+message);
    }

}
