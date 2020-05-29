package com.luzj.mych9_3_5;

import com.luzj.mych9_3_5.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luzj
 * @description:
 * @date 2018/8/15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TopicExchange {

    @Autowired
    TopicSender topicSender;

    @Test
    public void mingTest(){
        topicSender.sendMing();
    }

    @Test
    public void leeTest(){
        topicSender.sendAllTopic();
    }



}
