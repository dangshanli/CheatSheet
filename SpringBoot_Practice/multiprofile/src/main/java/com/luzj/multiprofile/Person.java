package com.luzj.multiprofile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author luzj
 * @description:
 * @date 2018/9/11
 */
@Component
public class Person {
    @Value("${com.luzj.name}")
    private String name;
    @Value("${com.luzj.weight}")
    private String weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
