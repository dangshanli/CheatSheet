package com.luzj.dblsource.repository.primary;

import com.luzj.dblsource.entity.primary.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luzj
 * @description:
 * @date 2018/8/20
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
