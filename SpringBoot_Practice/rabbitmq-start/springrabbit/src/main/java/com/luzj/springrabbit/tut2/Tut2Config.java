package com.luzj.springrabbit.tut2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: luzj
 * @date: 2018-11-28
 * @description:
 */
@Configuration
@Profile({"tut2","work-queues"})
public class Tut2Config {

    @Bean
    public Queue hello(){
        return new Queue("hello");
    }

    @Profile("sender")
    @Bean
    public Tut2Sender sender(){
        return new Tut2Sender();
    }

    @Profile("receiver")
    private static class ReceiverConfig{

        @Bean
        public Tut2Receiver receiver1(){
            return new Tut2Receiver(1);
        }

        @Bean
        public Tut2Receiver receiver2(){
            return new Tut2Receiver(2);
        }

    }
}
