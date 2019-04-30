package com.zhangwenit.zhanglei.demo.api.task;

import com.zhangwenit.zhanglei.demo.api.dto.wechat.MiniAccessTokenResponse;
import com.zhangwenit.zhanglei.demo.api.service.RedisService;
import com.zhangwenit.zhanglei.demo.api.util.WeChatRestApi;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description 定时刷新微信小程序access_token
 * @Author ZWen
 * @Date 2018/12/18 3:37 PM
 * @Version 1.0
 **/
@Component
public class MiniAccessTokenRefreshTask {

    private static final Logger logger = LoggerFactory.getLogger(MiniAccessTokenRefreshTask.class);

    private static final int REFRESH_SECOND = (50 + new Random().nextInt(31)) * 60;

    private final RedisService redisService;
    private final WeChatRestApi weChatRestApi;

    private final ScheduledExecutorService task;

    public MiniAccessTokenRefreshTask(RedisService redisService, WeChatRestApi weChatRestApi) {
        this.redisService = redisService;
        this.weChatRestApi = weChatRestApi;
        this.task = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder().namingPattern("accessToken-pool-%d").daemon(true).build());
        start();
    }

    private void start() {
        this.task.scheduleWithFixedDelay(this::refresh, 5, REFRESH_SECOND, TimeUnit.SECONDS);
        logger.info("Started MiniAccessToken refresh task");
    }

    /**
     * 50~80分钟执行一次，启动后延迟5秒后执行
     */
    public void refresh() {
        try {
            logger.info("开始刷新 MiniAccessToken");
            MiniAccessTokenResponse response = weChatRestApi.getMiniAccessToken();
            redisService.setAndExpireMiniAccessToken(response.getAccessToken());
            logger.info("刷新 MiniAccessToken 成功 , {}", response);
        } catch (Exception e) {
            logger.error("刷新 MiniAccessToken 失败 , Exception:{}", e);
        }

    }
}