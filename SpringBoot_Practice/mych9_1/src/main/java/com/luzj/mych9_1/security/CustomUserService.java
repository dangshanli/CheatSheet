package com.luzj.mych9_1.security;

import com.luzj.mych9_1.dao.SysUserRepository;
import com.luzj.mych9_1.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author luzj
 * @description: 自定义 UserDetailsService,重写认证规则——从指定表单中中查询用户
 * @date 2018/7/22
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("用户名不存在!!!");

        return user;
    }
}
