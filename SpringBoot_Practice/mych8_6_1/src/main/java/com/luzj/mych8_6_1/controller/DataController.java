package com.luzj.mych8_6_1.controller;

import com.luzj.mych8_6_1.dao.PersonRepository;
import com.luzj.mych8_6_1.domain.Location;
import com.luzj.mych8_6_1.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luzj
 * @description:
 * @date 2018/7/19
 */
@RestController
public class DataController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")//新增文档
    public Person save() {
        Person p = new Person("lzj", 77);
        Collection<Location> locations = new LinkedList<>();
        Location loc1 = new Location("上海", "2009");
        Location loc2 = new Location("合肥", "2010");
        Location loc3 = new Location("广州", "2011");
        Location loc4 = new Location("马鞍山", "2012");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);

        p.setLocations(locations);

        return personRepository.save(p);
    }


    @RequestMapping("/q1")//查询1
    public Person q1(String name) {
        return personRepository.findByName(name);
    }

    @RequestMapping("/q2")//查询2
    public List<Person> q2(Integer age) {
        return personRepository.withQueryFindByAge(age);
    }


}
