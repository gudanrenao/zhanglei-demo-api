package com.zhangwenit.zhanglei.demo.api.service;

import com.zhangwenit.zhanglei.demo.api.ZhangleiDemoApiApplication;
import com.zhangwenit.zhanglei.demo.api.model.User;
import com.zhangwenit.zhanglei.demo.api.repository.UserRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest(classes = ZhangleiDemoApiApplication.class)
@RunWith(SpringRunner.class)
//@ActiveProfiles("dev")
@Ignore
public class UserServiceTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void testLocalDateTime() throws Exception {
        User user = userRepository.findByName("ceshi");
        Assert.assertNotNull("user can be not null",user);
        System.out.println(user);
        user.setUpdateTime(LocalDateTime.now());
        userRepository.save(user);


    }

}