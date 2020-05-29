package com.luzj.ch8_5.dao;

import com.luzj.ch8_5.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luzj
 * @description:
 * @date 2018/7/17
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
