package com.luzj.dblsource.repository.primary;

import com.luzj.dblsource.entity.primary.RedAppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luzj
 * @description:
 * @date 2018/8/27
 */
public interface UserRepository extends JpaRepository<RedAppUser,String> {
    RedAppUser findByUserId(String userId);
}
