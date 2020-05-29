package com.luzj.mych9_3_5;

import java.io.Serializable;

/**
 * @author luzj
 * @description: 发送对象
 * @date 2018/8/15
 */
public class User implements Serializable {
    private String name;
    private String gender;
    private Integer age;

    public User() {
    }

    public User(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:"+name+",gender:"+gender+",age:"+age;
    }
}
