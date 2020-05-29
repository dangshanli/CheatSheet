package com.luzj.dblsource.repository.primary;

import com.luzj.dblsource.entity.primary.RedAppProcessExample;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author luzj
 * @description:
 * @date 2018/8/21
 */
public interface ProcessExampleRepository extends JpaRepository<RedAppProcessExample,String> {
    RedAppProcessExample findByExampleId(String exampleId);
}
