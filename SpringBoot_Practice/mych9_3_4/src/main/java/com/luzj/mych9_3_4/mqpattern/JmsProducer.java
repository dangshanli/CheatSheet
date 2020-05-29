package com.luzj.mych9_3_4.mqpattern;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;


/**
 * @author luzj
 * @description: 消息生产者
 * @date 2018/8/13
 */
@Component
public class JmsProducer {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;//jms消息客户端模板

    public void sendMessage(Destination destination, String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    /**
     * 发送字符串消息
     * @param message 消息字符串，其实可以是任意Object
     */
    public void send(String message){
        Destination destination = new ActiveMQQueue("my-destination");
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    public void sendByDes(String destination,String message){
        Destination destination1 = new ActiveMQQueue(destination);
        jmsMessagingTemplate.convertAndSend(destination1,message);
    }


}
