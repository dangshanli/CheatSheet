package com.luzj.springrabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: luzj
 * @date: 2018-11-27
 * @description: rabbit启动控制
 */
public class RabbitAmqpRunner implements CommandLineRunner {

    @Value("${tutorial.client.duration:0}")
    private int duration;

    @Autowired
    private ConfigurableApplicationContext ctx;

    //给消费者 和生产者留10秒钟时间
    @Override
    public void run(String... args) throws Exception {
        System.out.println("ready ... running for " + duration + "ms");
        Thread.sleep(duration);
        ctx.close();
    }
}
