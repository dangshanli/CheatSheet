package com.luzj.ch8_5.service.impl;

import com.luzj.ch8_5.dao.PersonRepository;
import com.luzj.ch8_5.domain.Person;
import com.luzj.ch8_5.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author luzj
 * @description:
 * @date 2018/7/17
 */
@Service
public class DemoServiceImpl implements DemoService{
    @Autowired
     PersonRepository personRepository;

    @Override
    @CachePut(value = "people",key = "#person.id")//添加或者更新缓存，key=person.id
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id、key="+p.getId()+"数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {//从people缓存中删除key=id的数据
        System.out.println("删除了id、key="+id+"数据缓存");
        personRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "people",key = "#person.id")//缓存key=person.id的数据到缓存中
    public Person findOne(Person person) {
        Person p = personRepository.findById(person.getId()).get();
        System.out.println("为id、key="+p.getId()+"数据做了缓存");
        return p;
    }
}
