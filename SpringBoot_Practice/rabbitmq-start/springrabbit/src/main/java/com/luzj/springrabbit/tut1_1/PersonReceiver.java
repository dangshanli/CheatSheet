package com.luzj.springrabbit.tut1_1;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.utils.SerializationUtils;

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author: luzj
 * @date: 2018-11-27
 * @description: 监听person队列 消费对象
 */

@RabbitListener(queues = "person")
public class PersonReceiver {

    @RabbitHandler
    public void receive(byte[] bytes) throws IOException, ClassNotFoundException {
        if (bytes==null ||bytes.length <=0) {
            System.out.println("233333333333");
            return;
        }

        Person person = (Person) SerializationUtils.deserialize(bytes);
        System.out.println(person);
    }
}
