package com.luzj.springrabbit.tut5;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: luzj
 * @date: 2018-11-29
 * @description: topic exchange 配置类
 * 0 topicExchange 不光可以指定交换机绑定的routing key,还可以使用#通配符
 * 1 sender用于发送交换机信息，他只需要和交换机交互即可
 * 2 receiver负责，实例化queue队列，以及将queue绑定到exchange，不同的Queue可以绑定不同的routing key，就像不同的暗号一样
 * 3 一个Queue只从exchange接收自己的routing key 对的上的信息
 * 4 最后sender和receiver的数据形式一定要一致，sender发送Object，receiver就拿Object接收。sender拿byte[] 发送，receiver必须拿byte[]接收
 */

@Configuration
@Profile({"tut5", "topics"})
public class Tut5Config {

    //交换机
    @Bean
    public TopicExchange topic() {
        return new TopicExchange("tut.topic");
    }

    //接收器，一般情况下，这部分bean都是部署在和sender不同的机器上，不然就没有搞什么队列中间件
    @Profile("receiver")
    private static class ReceiverConfig {

        //匿名队列，用完即删除的
        @Bean
        public Queue autoDeleteQueue1() {
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2() {
            return new AnonymousQueue();
        }

        //接收器，负责接收、消费消息
        @Bean
        public Tut5Receiver receiver() {
            return new Tut5Receiver();
        }

        //将队列和交换机绑定，通过不同routingKey ，* # 都是通配符，*代表任意单词，#代表无限多的单词
        @Bean
        public Binding binding1a(TopicExchange topic, Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1)
                    .to(topic)
                    .with("*.orange.*");
        }

        @Bean
        public Binding binding1b(TopicExchange topic, Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1)
                    .to(topic)
                    .with("*.*.rabbit");
        }

        @Bean
        public Binding binding2a(TopicExchange topic, Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2)
                    .to(topic)
                    .with("lazy.#");
        }

    }

    //发送器
    @Bean
    @Profile("sender")
    public Tut5Sender sender() {
        return new Tut5Sender();
    }


}
