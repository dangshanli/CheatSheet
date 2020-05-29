package com.luzj.mych9_3_5.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author luzj
 * @description:
 * @date 2018/8/15
 */
@Component
public class FanReceiver {
    @RabbitListener(queues = "q.a")
    public void receiveA(String message){
        System.err.println("[q.a]"+message);
    }

    @RabbitListener(queues = "q.b")
    public void receiveB(String message){
        System.err.println("[q.b]"+message);
    }

    @RabbitListener(queues = "q.c")
    public void receiveC(String message){
        System.err.println("[q.c]"+message);
    }




}
