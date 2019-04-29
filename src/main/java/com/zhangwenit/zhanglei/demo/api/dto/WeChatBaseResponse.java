package com.zhangwenit.zhanglei.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 11:29 PM
 * @Version 1.0
 **/
public class WeChatBaseResponse {

    @JsonProperty(value = "errcode", defaultValue = "0")
    private int errCode;
    @JsonProperty(value = "errmsg", defaultValue = "ok")
    private String errMsg;

    public WeChatBaseResponse() {
    }

    public boolean successful() {
        return this.errCode == 0;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "WeChatBaseResponse{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}