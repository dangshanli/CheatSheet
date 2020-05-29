package com.luzj.mych8_6_1.dao;

import com.luzj.mych8_6_1.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author luzj
 * @description: spring boot mongo支持 repository查询，使用方法和spring data jpa一样
 * @date 2018/7/19
 */
public interface PersonRepository extends MongoRepository<Person, String> {
    Person findByName(String name);

    @Query("{'age':?0}")//写好查询条件的json即可
    List<Person> withQueryFindByAge(Integer age);
}
