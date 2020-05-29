package com.luzj.mych9_3_4.pbpattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author luzj
 * @description: 订阅者，分别订阅topic-des和top-dd两个主题
 * @date 2018/8/13
 */
@Component
public class Subscriber {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    //destination标识订阅的主题名称
    @JmsListener(destination = "topic-des",containerFactory = "myJmsContainerFactory")
    public void subscribe(String message){
        System.err.println("==============<<<<<<<<<收到消息："+message);
    }
    @JmsListener(destination = "top-dd",containerFactory = "myJmsContainerFactory")
    public void sub2(String message){
        System.err.println("==============>>>>>>>>>收到消息："+message);
    }
}
