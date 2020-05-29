package com.luzj.mych9_3_5.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luzj
 * @description: Fanout模式类似于订阅模式，凡事绑定到交换机上的队列都会被推送消息
 * 1 想订阅某个交换机的消息，订阅绑定到该交换机上的任何一个队列即可
 * 2 如果想切换交换机的消息定于，只要将队列重新绑定到其他交换机即可
 * @date 2018/8/15
 */
@Configuration
public class FanoutConfig {
    @Bean(name = "aq")
    public Queue AQueue() {
        return new Queue("q.a");
    }

    @Bean(name = "bq")
    public Queue BQueue() {
        return new Queue("q.b");
    }

    @Bean(name = "cq")
    public Queue CQueue() {
        return new Queue("q.c");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout.a");
    }

    @Bean
    public Binding bindingA(Queue aq, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(aq).to(fanoutExchange);
    }

    @Bean
    public Binding bindingB(Queue bq, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(bq).to(fanoutExchange);
    }

    @Bean
    public Binding bindingC(Queue cq, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(cq).to(fanoutExchange);
    }


}
