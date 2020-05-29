package com.luzj.springrabbit.tut1_1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author: luzj
 * @date: 2018-11-27
 * @description: 生产者 发送Person对象到队列
 */
public class PersonSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    @Qualifier("person")
    private Queue queuePerson;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendPerson() throws IOException {
        Person person = new Person("张三" + UUID.randomUUID().toString().substring(0, 3),
                new Date(), (int) (Math.random() * 100));
        System.out.println(person);
        template.convertAndSend(queuePerson.getName(), SerializationUtils.serialize(person));
    }
}
