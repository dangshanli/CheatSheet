package com.luzj.dblsource.repository.primary;

import com.luzj.dblsource.entity.primary.RedAppProcessHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * @author luzj
 * @description:
 * @date 2018/8/21
 */
public interface ProcessHistoryRepository extends JpaRepository<RedAppProcessHistory,String> {
    RedAppProcessHistory findTopByExampleIdAndStepIdInOrderByEndTimeDesc(String exampleId, Collection<String> stepIds);
}
