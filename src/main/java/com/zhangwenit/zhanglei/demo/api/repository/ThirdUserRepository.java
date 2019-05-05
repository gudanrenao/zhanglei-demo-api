package com.zhangwenit.zhanglei.demo.api.repository;

import com.zhangwenit.zhanglei.demo.api.model.ThirdUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author by zhangwen
 */
public interface ThirdUserRepository extends JpaRepository<ThirdUser, Long>, JpaSpecificationExecutor<ThirdUser> {

    ThirdUser findByMiniOpenId(String miniOpenId);
    ThirdUser findByUnionId(String unionId);
}
