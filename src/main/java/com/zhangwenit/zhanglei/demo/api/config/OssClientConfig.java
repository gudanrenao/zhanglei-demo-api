package com.zhangwenit.zhanglei.demo.api.config;

import com.aliyun.oss.OSSClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/30 5:08 PM
 * @Version 1.0
 **/
@Configuration
@EnableConfigurationProperties({OssClientConfig.OssProperties.class})
public class OssClientConfig {

    private final OssProperties ossProperties;

    public OssClientConfig(OssProperties ossProperties) {
        this.ossProperties = ossProperties;
    }

    @Bean
    public OSSClient ossClient() {
        return new OSSClient(ossProperties.endpoint, ossProperties.accessKeyId, ossProperties.accessKeySecret);
    }

    @ConfigurationProperties(prefix = "oss")
    public static class OssProperties {

        @NotNull
        private String endpoint;
        @NotNull
        private String bucket;
        @NotNull
        private String accessKeyId;
        @NotNull
        private String accessKeySecret;
        @NotNull
        private String domainName;

        @NotNull
        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(@NotNull String endpoint) {
            this.endpoint = endpoint;
        }

        @NotNull
        public String getBucket() {
            return bucket;
        }

        public void setBucket(@NotNull String bucket) {
            this.bucket = bucket;
        }

        @NotNull
        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(@NotNull String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        @NotNull
        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(@NotNull String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }

        @NotNull
        public String getDomainName() {
            return domainName;
        }

        public void setDomainName(@NotNull String domainName) {
            this.domainName = domainName;
        }
    }
}