package com.zhangwenit.zhanglei.demo.api.task;

import com.zhangwenit.zhanglei.demo.api.dto.wechat.PublicAccessTokenResponse;
import com.zhangwenit.zhanglei.demo.api.service.RedisService;
import com.zhangwenit.zhanglei.demo.api.util.WeChatRestApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description 定时刷新公众号access_token
 * @Author ZWen
 * @Date 2018/12/18 3:37 PM
 * @Version 1.0
 **/
@Component
public class PublicAccessTokenRefreshTask {

    private static final Logger logger = LoggerFactory.getLogger(PublicAccessTokenRefreshTask.class);

    private static final int REFRESH_SECOND = (50 + new Random().nextInt(31)) * 60;

    private final RedisService redisService;
    private final WeChatRestApi weChatRestApi;

    private final ScheduledExecutorService tokenRefreshScheduledExecutorService;

    public PublicAccessTokenRefreshTask(RedisService redisService, WeChatRestApi weChatRestApi, ScheduledExecutorService tokenRefreshScheduledExecutorService) {
        this.redisService = redisService;
        this.weChatRestApi = weChatRestApi;
        this.tokenRefreshScheduledExecutorService = tokenRefreshScheduledExecutorService;
        start();
    }

    private void start() {
        this.tokenRefreshScheduledExecutorService.scheduleWithFixedDelay(this::refresh, 10, REFRESH_SECOND, TimeUnit.SECONDS);
        logger.info("Started publicAccessToken refresh task");
    }

    /**
     * 50~80分钟执行一次，启动后延迟60~120秒后执行
     */
    public void refresh() {
        try {
            logger.info("开始刷新 publicAccessToken");
            PublicAccessTokenResponse response = weChatRestApi.getPublicAccessToken();
            redisService.setAndExpirePublicAccessToken(response.getAccessToken());
            logger.info("刷新 publicAccessToken 成功 , {}", response);
        } catch (Exception e) {
            logger.error("刷新 publicAccessToken 失败 , Exception:{}", e);
        }
    }
}