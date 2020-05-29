package com.luzj.multiprofile;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiprofileApplicationTests {

    @Autowired
    Person person;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDev() {
        Assert.assertEquals(person.getName(), "开发环境");
        Assert.assertEquals(person.getWeight(), "3000金");
    }

    @Test
    public void testProd() {
        Assert.assertEquals(person.getName(), "生产环境");
        Assert.assertEquals(person.getWeight(), "5000金");
    }

}
