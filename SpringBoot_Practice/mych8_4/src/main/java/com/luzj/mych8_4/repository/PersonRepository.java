package com.luzj.mych8_4.repository;

import com.luzj.mych8_4.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luzj
 * @description:
 * @date 2018/7/13
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
