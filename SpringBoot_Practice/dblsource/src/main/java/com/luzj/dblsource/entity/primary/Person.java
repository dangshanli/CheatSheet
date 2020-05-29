package com.luzj.dblsource.entity.primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author luzj
 * @description: primary 数据库，测试实体类
 * @date 2018/8/20
 */
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Integer id;

    private String address;

    private Integer age;

    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Person() {
    }

    public Person(String address, Integer age, String name) {
        this.address = address;
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
