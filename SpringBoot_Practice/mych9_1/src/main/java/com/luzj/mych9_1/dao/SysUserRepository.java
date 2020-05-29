package com.luzj.mych9_1.dao;

import com.luzj.mych9_1.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author luzj
 * @description: 数据访问层
 * @date 2018/7/22
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    SysUser findByUsername(String userName);
}
