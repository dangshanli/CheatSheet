package com.luzj.dblsource.repository.primary;

import com.luzj.dblsource.entity.primary.RedAppImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author luzj
 * @description:
 * @date 2018/8/27
 */
public interface RedAppImageRepository extends JpaRepository<RedAppImage,String> {
    List<RedAppImage> findByImageId(String imageId);
}
