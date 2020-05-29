package com.luzj.mych8_4.service.impl;

import com.luzj.mych8_4.domain.Person;
import com.luzj.mych8_4.repository.PersonRepository;
import com.luzj.mych8_4.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author luzj
 * @description: 给方法添加@Transactional注解，添加事务
 * 0 rollbackFor属性指定回滚的异常
 * 1 noRollbackFor属性指定一定不触发回滚的异常
 * @date 2018/7/13
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    PersonRepository personRepository;

    /**
     * 当入参name=路章健时，抛出异常，出发回滚，使得插入数据失败
     * @param person
     * @return
     */
    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})//非法参数异常回滚
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("路章健"))
            throw new IllegalArgumentException("路章健已经存在，数据回滚");
        return p;
    }

    /**
     * 指定一定不会触发回滚的异常
     * @param person
     * @return
     */
    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})//非法异常参数不会滚
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("路章健"))
            throw new IllegalArgumentException("路章健已经存在，数据不会滚");
        return p;
    }
}
