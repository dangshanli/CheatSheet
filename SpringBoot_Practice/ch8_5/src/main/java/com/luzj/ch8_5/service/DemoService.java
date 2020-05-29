package com.luzj.ch8_5.service;

import com.luzj.ch8_5.domain.Person;

/**
 * @author luzj
 * @description:
 * @date 2018/7/17
 */
public interface DemoService {
    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);
}
