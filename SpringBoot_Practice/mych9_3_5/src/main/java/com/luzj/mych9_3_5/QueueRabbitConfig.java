package com.luzj.mych9_3_5;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luzj
 * @description:
 * @date 2018/8/14
 */
@Configuration
public class QueueRabbitConfig {
    @Bean
    public Queue wiselyQueue(){
        return new Queue("my-queue");//定义目的地队列
    }

    @Bean
    public Queue luzjQueue(){
        return new Queue("karas");
    }

    @Bean
    public Queue fishQueue(){//不再接受字符串，开始接受对象
        return new Queue("fish");
    }



}
