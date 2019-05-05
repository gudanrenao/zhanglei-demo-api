package com.zhangwenit.zhanglei.demo.api.repository;

import com.zhangwenit.zhanglei.demo.api.model.PcManageUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author by zhangwen
 */
public interface PcManageUserRepository extends JpaRepository<PcManageUser, Long> {

    /**
     * 根据账户名查询账户信息
     *
     * @param name
     * @param isDelete
     * @return
     */
    PcManageUser findByNameAndIsDelete(String name, Integer isDelete);

    List<PcManageUser> findAllByIsDelete(Integer isDelete);
}
