package com.zhangwenit.zhanglei.demo.api.service;

import com.alibaba.fastjson.JSON;
import com.zhangwenit.zhanglei.demo.api.config.RedisConfig;
import com.zhangwenit.zhanglei.demo.api.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/25 9:46 PM
 * @Version 1.0
 **/
@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 登录成功保存到redis
     *
     * @param user
     * @return head token
     */
    public String setLoginInfo(User user) {
        String redisKey = "login:" + System.currentTimeMillis();
        String value = JSON.toJSONString(user);
        redisTemplate.opsForValue().set(redisKey, value, RedisConfig.LOGIN_EXPIRE_SECOND, TimeUnit.SECONDS);
        return redisKey;
    }

    /**
     * 获取token
     *
     * @param token
     * @return
     */
    public User findByToken(final String token) {
        String value = redisTemplate.opsForValue().get(token);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return JSON.parseObject(value, User.class);
    }

    /**
     * 删除token
     *
     * @param token
     * @return
     */
    public boolean delToken(final String token) {
        return redisTemplate.delete(token);
    }

    public void reExpireToken(String token){
        redisTemplate.expire(token,RedisConfig.LOGIN_EXPIRE_SECOND, TimeUnit.SECONDS);
    }
}