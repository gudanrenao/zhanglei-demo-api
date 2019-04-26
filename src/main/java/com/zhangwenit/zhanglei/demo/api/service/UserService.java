package com.zhangwenit.zhanglei.demo.api.service;

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

    public List<User> findAllUser(){
        return userRepository.findAll();
    }
}
