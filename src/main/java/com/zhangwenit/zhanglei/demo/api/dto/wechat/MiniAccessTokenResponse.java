package com.zhangwenit.zhanglei.demo.api.dto.wechat;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/30 2:07 PM
 * @Version 1.0
 **/
public class MiniAccessTokenResponse extends WeChatBaseResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Integer expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "MiniAccessTokenResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}