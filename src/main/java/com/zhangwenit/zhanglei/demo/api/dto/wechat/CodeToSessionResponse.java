package com.zhangwenit.zhanglei.demo.api.dto.wechat;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 11:22 PM
 * @Version 1.0
 **/
public class CodeToSessionResponse extends WeChatBaseResponse {

    @JsonProperty("openid")
    private String openId;
    @JsonProperty("session_key")
    private String sessionKey;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "CodeToSessionResponse{" +
                "openId='" + openId + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                '}';
    }
}