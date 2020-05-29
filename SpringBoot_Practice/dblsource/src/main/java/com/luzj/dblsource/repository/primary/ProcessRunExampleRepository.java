package com.luzj.dblsource.repository.primary;

import com.luzj.dblsource.entity.primary.RedAppProcessRunExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author luzj
 * @description:
 * @date 2018/8/21
 */
public interface ProcessRunExampleRepository extends JpaRepository<RedAppProcessRunExample,String> {

    @Query(value = "SELECT  pre.exampleId from redAppProcessRunExample pre where pre.starTime LIKE ?1% and pre.status = ?2 and pre.stepId = ?3",nativeQuery = true)
    List<String> findByStarTimeLikeAndStatusAndStepId(String starTime,String status,String stepId);

    RedAppProcessRunExample findByExampleId(String exampleId);
}
