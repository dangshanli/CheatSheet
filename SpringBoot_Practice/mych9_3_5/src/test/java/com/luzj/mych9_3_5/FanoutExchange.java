package com.luzj.mych9_3_5;

import com.luzj.mych9_3_5.fanout.FanoutSender;
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
public class FanoutExchange {

    @Autowired
    FanoutSender fanoutSender;

    @Test
    public void testBoardCast() {
        fanoutSender.sendFan("黄沙百战穿金甲");
    }

}
