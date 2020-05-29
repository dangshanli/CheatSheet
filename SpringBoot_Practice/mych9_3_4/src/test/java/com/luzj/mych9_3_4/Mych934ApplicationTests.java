package com.luzj.mych9_3_4;

import com.luzj.mych9_3_4.mqpattern.JmsProducer;
import com.luzj.mych9_3_4.pbpattern.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mych934ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    JmsProducer jmsProducer;

    /**
     * 单元测试，生产者send消息，可以看到监听者自动获取到从队列里面获取到消息，并且消费
     */
    @Test
    public void activeMq() {
        for (int i = 0; i < 10; i++) {
            jmsProducer.send("消息体:[" + i + "]========================================");
        }
    }

    /**
     * 多消费者测试
     */
    @Test
    public void multiActiveMq() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0)
                jmsProducer.sendByDes("my-destination",
                        "消息体:[" + i + "]========================================");
            else
                jmsProducer.sendByDes("my-karas",
                        "消息体:[" + i + "]========================================");
        }
    }

    @Autowired
    Publisher publisher;

    //pb模式测试，使用发布者发布主题信息，观察消费者是否会自动消费
    @Test
    public void pbPattern() {
        String des = "topic-des";
        String des1 = "top-dd";
        for (int i = 10; i < 30; i++) {
            if (i % 2 == 0)
                publisher.publish(des, "[" + des + "] 消息体<" + i + ">");
            else
                publisher.publish(des1, "[" + des1 + "] 消息体<" + i + ">");
        }
    }

}
