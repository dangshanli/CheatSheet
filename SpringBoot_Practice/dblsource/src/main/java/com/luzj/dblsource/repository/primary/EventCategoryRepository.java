package com.luzj.dblsource.repository.primary;

import com.luzj.dblsource.entity.primary.RedAppEventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luzj
 * @description:
 * @date 2018/8/27
 */
public interface EventCategoryRepository extends JpaRepository<RedAppEventCategory,String> {
    RedAppEventCategory findTopByCategoryId(String categoryId);
    RedAppEventCategory findTopByBigCategoryId(String bigCategoryId);
    RedAppEventCategory findTopBySmallCategoryId(String smallCategoryId);
    RedAppEventCategory findTopByDetailCategoryId(String detailCategoryId);
}
