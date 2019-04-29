package com.zhangwenit.zhanglei.demo.api.dto;

import java.io.Serializable;

public class MiniLoginUser implements Serializable {

    private long origId;
    private String appId;
    private String secret;
    private String jsCode;
    private String grantType;
    private String openId;
    private String sessionKey;
    private String encryptedData;
    private String rdSessionId;
    private String iv;
    private String code;

    private static final long serialVersionUID = 1L;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getJsCode() {
        return jsCode;
    }

    public void setJsCode(String jsCode) {
        this.jsCode = jsCode;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

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

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getRdSessionId() {
        return rdSessionId;
    }

    public void setRdSessionId(String rdSessionId) {
        this.rdSessionId = rdSessionId;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public long getOrigId() {
        return origId;
    }

    public void setOrigId(long origId) {
        this.origId = origId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
