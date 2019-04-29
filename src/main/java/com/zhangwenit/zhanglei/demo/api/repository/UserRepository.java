package com.zhangwenit.zhanglei.demo.api.repository;

import com.zhangwenit.zhanglei.demo.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author by zhangwen
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据账户名查询账户信息
     *
     * @param name
     * @return
     */
    User findByName(String name);
}
