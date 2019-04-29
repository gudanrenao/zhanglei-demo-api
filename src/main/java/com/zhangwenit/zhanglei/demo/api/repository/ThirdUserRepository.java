package com.zhangwenit.zhanglei.demo.api.repository;

import com.zhangwenit.zhanglei.demo.api.model.ThirdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author by zhangwen
 */
public interface ThirdUserRepository extends JpaRepository<ThirdUser, Long> {

    ThirdUser findByOpenId(String openId);
}
