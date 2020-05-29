package com.luzj.mych9_3_5.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author luzj
 * @description:
 * @date 2018/8/15
 */
@Component
public class TopicReceivers {

    @RabbitListener(queues = "topic.ming")
    public void fromMing(String message){
        System.err.println("receive from topic.ming:>>>"+message+"<<<");
    }

    @RabbitListener(queues = "topic.lee")
    public void fromAll(String message){
        System.err.println("receive from topic.lee:>>>"+message+"<<<");
    }



}
