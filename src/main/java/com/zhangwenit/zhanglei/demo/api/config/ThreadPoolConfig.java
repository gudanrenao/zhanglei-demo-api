package com.zhangwenit.zhanglei.demo.api.config;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @Description 线程池配置
 * @Author ZWen
 * @Date 2019/5/5 4:47 PM
 * @Version 1.0
 **/
@Configuration
@Order(1)
public class ThreadPoolConfig {

    /**
     * 定时任务专用线程池
     *
     * @return
     */
    @Bean
    public ScheduledExecutorService tokenRefreshScheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(2, new BasicThreadFactory.Builder().namingPattern("tokenRefresh-schedule-pool-%d").daemon(true).build());
    }
}