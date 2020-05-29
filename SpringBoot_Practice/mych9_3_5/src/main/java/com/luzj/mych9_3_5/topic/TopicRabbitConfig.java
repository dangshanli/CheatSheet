package com.luzj.mych9_3_5.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author luzj
 * @description:
 * @date 2018/8/15
 */
@Configuration
public class TopicRabbitConfig {
    public static final String MING = "topic.ming";
    public static final String LEE = "topic.lee";

    @Bean
    public Queue ming(){
        return new Queue(TopicRabbitConfig.MING);
    }
    @Bean
    public Queue lee(){
        return new Queue(TopicRabbitConfig.LEE);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    public Binding bindingMing(Queue ming,TopicExchange exchange){
        return BindingBuilder.bind(ming).to(exchange).with("topic.ming");
    }

    @Bean
    public Binding bindingLee(Queue lee,TopicExchange exchange){
        return BindingBuilder.bind(lee).to(exchange).with("topic.#");
    }





}
