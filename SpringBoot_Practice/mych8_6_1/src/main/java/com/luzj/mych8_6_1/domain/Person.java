package com.luzj.mych8_6_1.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author luzj
 * @description:
 * @date 2018/7/19
 */
@Document//注册该类成为一个mongodb的文档
public class Person {
    @Id
    private String id;//主键，value会由mongo自动生成

    private String name;

    private Integer age;

    @Field("locs")//将集合声明为一个文档中的一个field
    private Collection<Location> locations = new LinkedList<>();

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }
}
