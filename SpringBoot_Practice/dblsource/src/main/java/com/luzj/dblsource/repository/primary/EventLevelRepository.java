package com.luzj.dblsource.repository.primary;

import com.luzj.dblsource.entity.primary.RedAppEventLevel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luzj
 * @description:
 * @date 2018/8/27
 */
public interface EventLevelRepository extends JpaRepository<RedAppEventLevel,String> {
    RedAppEventLevel findByLevelId(String levelId);
}
