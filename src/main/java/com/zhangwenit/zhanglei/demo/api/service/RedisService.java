package com.zhangwenit.zhanglei.demo.api.service;

import com.alibaba.fastjson.JSON;
import com.zhangwenit.zhanglei.demo.api.config.RedisConfig;
import com.zhangwenit.zhanglei.demo.api.constant.WeChatConstant;
import com.zhangwenit.zhanglei.demo.api.model.ThirdUser;
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

    private static final String LOGIN_KEY_PREFIX = "login:";
    private static final String MINI_LOGIN_KEY_PREFIX = "miniLogin:";

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
        String redisKey = LOGIN_KEY_PREFIX + System.currentTimeMillis();
        redisTemplate.opsForValue().set(redisKey, JSON.toJSONString(user), RedisConfig.LOGIN_EXPIRE_SECOND, TimeUnit.SECONDS);
        return redisKey;
    }

    /**
     * 小程序登录成功保存到redis
     *
     * @param user
     * @return head token
     */
    public String setMiniLoginInfo(ThirdUser user) {
        String redisKey = MINI_LOGIN_KEY_PREFIX + System.currentTimeMillis();
        redisTemplate.opsForValue().set(redisKey, JSON.toJSONString(user), RedisConfig.MINI_LOGIN_EXPIRE_SECOND, TimeUnit.SECONDS);
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
     * 获取小程序token
     *
     * @param token
     * @return
     */
    public ThirdUser findByMiniToken(final String token) {
        String value = redisTemplate.opsForValue().get(token);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return JSON.parseObject(value, ThirdUser.class);
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

    public void reExpireToken(String token) {
        redisTemplate.expire(token, RedisConfig.LOGIN_EXPIRE_SECOND, TimeUnit.SECONDS);
    }

    public void reExpireMiniToken(String token) {
        redisTemplate.expire(token, RedisConfig.MINI_LOGIN_EXPIRE_SECOND, TimeUnit.SECONDS);
    }

    /**
     * 保存MiniAccessToken,并设置两个小时的过期时间
     *
     * @param accessToken
     */
    public void setAndExpireMiniAccessToken(String accessToken) {
        redisTemplate.opsForValue().set(WeChatConstant.MINI_ACCESS_TOKEN_REDIS_KEY, accessToken);
        redisTemplate.expire(WeChatConstant.MINI_ACCESS_TOKEN_REDIS_KEY, WeChatConstant.MINI_ACCESS_TOKEN_REDIS_EXPIRE_SECOND, TimeUnit.SECONDS);
    }

    /**
     * 获取MiniAccessToken
     */
    public String getMiniAccessToken() {
        return redisTemplate.opsForValue().get(WeChatConstant.MINI_ACCESS_TOKEN_REDIS_KEY);
    }
}