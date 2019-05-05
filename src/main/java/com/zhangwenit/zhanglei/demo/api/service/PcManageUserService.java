package com.zhangwenit.zhanglei.demo.api.service;

import com.zhangwenit.zhanglei.demo.api.constant.StateConstant;
import com.zhangwenit.zhanglei.demo.api.dto.LoginDto;
import com.zhangwenit.zhanglei.demo.api.enums.CommonExceptionEnum;
import com.zhangwenit.zhanglei.demo.api.exception.CommonException;
import com.zhangwenit.zhanglei.demo.api.model.PcManageUser;
import com.zhangwenit.zhanglei.demo.api.repository.PcManageUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhangwen at 2018-08-15 22:55
 **/
@Service
public class PcManageUserService {

    private final PcManageUserRepository pcManageUserRepository;

    public PcManageUserService(PcManageUserRepository pcManageUserRepository) {
        this.pcManageUserRepository = pcManageUserRepository;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void save(PcManageUser user) {
        pcManageUserRepository.save(user);
    }

    public PcManageUser findByName(String name) {
        return pcManageUserRepository.findByNameAndIsDelete(name, StateConstant.ROW_IS_NOT_DELETE);
    }

    public List<PcManageUser> findAllUser() {
        return pcManageUserRepository.findAllByIsDelete(StateConstant.ROW_IS_NOT_DELETE);
    }

    public PcManageUser findById(Long userId) {
        return pcManageUserRepository.findById(userId).orElseThrow(() -> new CommonException("user not found"));
    }

    /**
     * 冻结账户
     *
     * @param user   当前登录账号
     * @param userId 被冻结账户id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void freeze(PcManageUser user, Long userId) {
        if (user.getType() != StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.PERMISSION_DENIED);
        }
        PcManageUser freezeUser = findById(userId);
        if (freezeUser.getType() == StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.MANAGE_USER_EDIT_ERROR);
        }
        if (freezeUser.getState() != StateConstant.USER_STATE_ACTIVE) {
            throw new CommonException("user state error");
        }
        freezeUser.setState(StateConstant.USER_STATE_FREEZE);
        freezeUser.setUpdateTime(LocalDateTime.now());
        pcManageUserRepository.save(freezeUser);
    }

    /**
     * 激活账户
     *
     * @param user   当前登录账号
     * @param userId 待激活账户id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void active(PcManageUser user, Long userId) {
        if (user.getType() != StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.PERMISSION_DENIED);
        }
        PcManageUser activeUser = findById(userId);
        if (activeUser.getType() == StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.MANAGE_USER_EDIT_ERROR);
        }
        if (activeUser.getState() != StateConstant.USER_STATE_FREEZE) {
            throw new CommonException("user state error");
        }
        activeUser.setState(StateConstant.USER_STATE_ACTIVE);
        activeUser.setUpdateTime(LocalDateTime.now());
        pcManageUserRepository.save(activeUser);
    }

    /**
     * 删除当前账号
     *
     * @param user
     * @param userId
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(PcManageUser user, Long userId) {
        if (user.getType() != StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.PERMISSION_DENIED);
        }
        PcManageUser delUser = findById(userId);
        if (delUser.getType() == StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.MANAGE_USER_EDIT_ERROR);
        }
        delUser.setIsDelete(1);
        delUser.setUpdateTime(LocalDateTime.now());
        pcManageUserRepository.save(delUser);
    }

    /**
     * 创建账号
     *
     * @param user
     * @param loginDto
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void create(PcManageUser user, LoginDto loginDto) {
        if (user.getType() != StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.PERMISSION_DENIED);
        }
        if (StringUtils.isEmpty(loginDto.getUsername()) || StringUtils.isEmpty(loginDto.getPassword())) {
            throw new CommonException(CommonExceptionEnum.NAME_OR_PWD_NULL);
        }
        //数据库中用户名不能已存在
        PcManageUser manageUser = findByName(loginDto.getUsername());
        if (manageUser != null) {
            throw new CommonException(CommonExceptionEnum.NAME_ALREADY_EXIST);
        }
        manageUser = new PcManageUser();
        manageUser.setName(loginDto.getUsername());
        manageUser.setPassword(DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes()));
        manageUser.setIsDelete(0);
        manageUser.setUpdateTime(LocalDateTime.now());
        manageUser.setState(StateConstant.USER_STATE_ACTIVE);
        manageUser.setType(StateConstant.USER_TYPE_ORDINARY);
        pcManageUserRepository.save(manageUser);
    }
}
