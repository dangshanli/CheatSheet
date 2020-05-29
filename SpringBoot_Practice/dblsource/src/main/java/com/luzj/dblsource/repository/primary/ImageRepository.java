package com.luzj.dblsource.repository.primary;

import com.luzj.dblsource.entity.primary.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
}
