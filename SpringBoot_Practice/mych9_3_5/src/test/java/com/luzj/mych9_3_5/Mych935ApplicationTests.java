package com.luzj.mych9_3_5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mych935ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    RabbitSender rabbitSender;

    @Test
    public void rabbitTest() {
        rabbitSender.send();
    }

    //多个发送器和接收器，使用Queue
    //一个消息，有两个接收器都监听的情况下，他们会均匀的从队列去消息，同时请记住，队列的消息只能给一个人消费，之后就完了
    @Test
    public void multiRabbit() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0)
                rabbitSender.send();
            else
                rabbitSender.sendToKaras(String.valueOf(i));
        }
    }

    //传输成对象
    @Test
    public void tansfUser() {
        for (int i = 0; i < 10; i++) {
            User user = new User("李" + i + "光", i % 2 == 0 ? "男" : "女", i);
            rabbitSender.sendToFish(user);
        }
    }

}
