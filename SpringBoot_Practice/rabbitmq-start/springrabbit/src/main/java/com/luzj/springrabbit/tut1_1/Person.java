package com.luzj.springrabbit.tut1_1;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: luzj
 * @date: 2018-11-27
 * @description:
 */
public class Person implements Serializable {
    private String name;
    private Date birthday;
    private int age;

    public Person(String name, Date birthday, int age) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }
}
