package com.luzj.mych8_4.service;

import com.luzj.mych8_4.domain.Person;

/**
 * @author luzj
 * @description:
 * @date 2018/7/13
 */
public interface DemoService {
    Person savePersonWithRollBack(Person person);
    Person savePersonWithoutRollBack(Person person);
}
