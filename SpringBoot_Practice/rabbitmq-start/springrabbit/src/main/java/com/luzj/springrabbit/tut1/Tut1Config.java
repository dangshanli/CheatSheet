package com.luzj.springrabbit.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: luzj
 * @date: 2018-11-27
 * @description:
 */
@Profile({"tut1","hello-world"})
@Configuration
public class Tut1Config {

    @Bean("hello")
    public Queue hello(){
        return new Queue("hello");
    }

    @Bean
    @Profile("receiver")
    public Tut1Receiver receiver(){
        return new Tut1Receiver();
    }

    @Bean
    @Profile("sender")
    public Tut1Sender sender(){
        return new Tut1Sender();
    }

}
