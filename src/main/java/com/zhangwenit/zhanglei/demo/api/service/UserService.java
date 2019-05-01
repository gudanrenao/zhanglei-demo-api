package com.zhangwenit.zhanglei.demo.api.service;

import com.zhangwenit.zhanglei.demo.api.constant.StateConstant;
import com.zhangwenit.zhanglei.demo.api.enums.CommonExceptionEnum;
import com.zhangwenit.zhanglei.demo.api.exception.CommonException;
import com.zhangwenit.zhanglei.demo.api.model.User;
import com.zhangwenit.zhanglei.demo.api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangwen at 2018-08-15 22:55
 **/
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void save(User user) {
        userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new CommonException("user not found"));
    }

    /**
     * 冻结账户
     *
     * @param user   当前登录账号
     * @param userId 被冻结账户id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void freeze(User user, Long userId) {
        if (user.getType() != StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.PERMISSION_DENIED);
        }
        User freezeUser = findById(userId);
        if (freezeUser.getType() == StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.MANAGE_USER_EDIT_ERROR);
        }
        if (freezeUser.getState() != StateConstant.USER_STATE_ACTIVE) {
            throw new CommonException("user state error");
        }
        freezeUser.setState(StateConstant.USER_STATE_FREEZE);
        userRepository.save(freezeUser);
    }

    /**
     * 激活账户
     *
     * @param user   当前登录账号
     * @param userId 待激活账户id
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void active(User user, Long userId) {
        if (user.getType() != StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.PERMISSION_DENIED);
        }
        User activeUser = findById(userId);
        if (activeUser.getType() == StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.MANAGE_USER_EDIT_ERROR);
        }
        if (activeUser.getState() != StateConstant.USER_STATE_FREEZE) {
            throw new CommonException("user state error");
        }
        activeUser.setState(StateConstant.USER_STATE_ACTIVE);
        userRepository.save(activeUser);
    }
}
