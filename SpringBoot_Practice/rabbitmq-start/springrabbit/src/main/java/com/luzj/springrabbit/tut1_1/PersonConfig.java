package com.luzj.springrabbit.tut1_1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: luzj
 * @date: 2018-11-27
 * @description:
 */
@Configuration
@Profile({"tut11","hello-person"})
public class PersonConfig {

    @Bean("person")
    public Queue person(){
        return new Queue("person");
    }

    @Bean
    @Profile("receiver")
    public PersonReceiver personReceiver(){
        return new PersonReceiver();
    }

    @Bean
    @Profile("sender")
    public PersonSender personSender(){
        return new PersonSender();
    }
}
