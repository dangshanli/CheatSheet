package com.luzj.springrabbit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringrabbitApplication {

    //默认控制台启动无效 必须打jar包 激活指定的profile
    @Bean
    @Profile("usage_message")
    public CommandLineRunner usage() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("This app uses Spring Profiles to control its behavior.\n");
                System.out.println("Sample usage: java -jar rabbit-tutorials.jar " +
                        "--spring.profiles.active=hello-world,sender");
            }
        };
    }

    //通过java -jar指令启动的入口
    @Bean
    @Profile("!usage_message")
    public CommandLineRunner tutorial(){
        return new RabbitAmqpRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringrabbitApplication.class, args);
    }
}
