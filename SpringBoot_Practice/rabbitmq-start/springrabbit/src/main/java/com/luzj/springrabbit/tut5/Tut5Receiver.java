package com.luzj.springrabbit.tut5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * @author: luzj
 * @date: 2018-11-29
 * @description: 接收器，负责从队列接收消息，并且处理
 */
public class Tut5Receiver {

    //不同的方法g监听不同的队列处理不同类型的消息
    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(String in) throws InterruptedException {
        receive(in,1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receive2(String in) throws InterruptedException {
        receive(in,2);
    }


    public void receive(String in, int receiver) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance " + receiver + " [x] received '" + in + "'");
        doWork(in);
        watch.stop();
        System.out.println("instance " + receiver + " [x] done in " +
                watch.getTotalTimeSeconds() + " s");
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.')
                Thread.sleep(1000);

        }
    }


}
