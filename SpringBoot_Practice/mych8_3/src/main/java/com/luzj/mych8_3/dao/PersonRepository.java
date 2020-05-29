package com.luzj.mych8_3.dao;

import com.luzj.mych8_3.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author luzj
 * @description: 作为rest资源的repository
 * 0 所有的从JpaRepository继承的方法都是rest资源
 * 1 通过http://localhost:8080/persons/访问全部的对象
 * 2 person?page=1&size=3分页访问
 * 3 persons?1 访问id=1的数据条目
 * 4 persons/search/nameStartsWith?name=路，访问自定义查询方法
 * 5 排序访问 persons/?sort=age,desc
 * 6 persons ,保存，{请求体},post请求
 * 7 更新请求，persons/13,修改id为13的数据条目，{请求体，json格式}，put请求
 * 8 删除请求，person/13 ，删除id=13的数据条目，delete请求
 *
 * @date 2018/7/12
 */
//自定义节点的路径，默认情况是persons,现在自定义为people，即ip:port/api/people?....,其中/api为repository资源的自定义的根节点
@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person,Long> {

    /**
     * 通过RestResource注解，将该方法暴露为rest资源
     * @param name
     * @return
     */
    @RestResource(path = "nameStartsWith",rel = "nameStartsWith")
    Person findByNameStartsWith(@Param("name") String name);
}
