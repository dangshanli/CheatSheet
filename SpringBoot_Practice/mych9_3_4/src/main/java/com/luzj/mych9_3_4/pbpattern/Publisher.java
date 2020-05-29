package com.luzj.mych9_3_4.pbpattern;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author luzj
 * @description: 主题发布订阅模式，发布者
 * @date 2018/8/13
 */
@Component
public class Publisher {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    public void publish(String destination,String message){
        Destination des = new ActiveMQTopic(destination);//使用ActiveMQTopic对象做包装
        jmsMessagingTemplate.convertAndSend(des,message);
    }
}
