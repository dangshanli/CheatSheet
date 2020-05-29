package com.luzj.mych9_3_5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author luzj
 * @description: 定义rabbit监听器，这个同activemq基本相似
 * 0 定义目的地队列
 * 1 生产者发送对象或者消息进入队列
 * 2 消费者预先定义监听某个目的地队列
 * 3 一旦队列里面有消息，监听者立马就去队列里面去消息消费
 * 4 同样的，每个消息只能给一个人消费一次，而发布-订阅模式则可以供多人消费
 * @date 2018/8/14
 */
@Component
public class Receiver {
    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message){
        System.err.println("Received <"+message+">");
    }

    @RabbitListener(queues = "karas")
    public void receiveKaras(String message){
        System.err.println(message);
    }

    @RabbitListener(queues = "karas")
    public void getKaras(String message){
        System.err.println(message+"================blink-blink-blink");
    }

    @RabbitListener(queues = "fish")
    public void getFish(User user){
        System.err.println("[fish]>>>>>>"+user);
    }
}
