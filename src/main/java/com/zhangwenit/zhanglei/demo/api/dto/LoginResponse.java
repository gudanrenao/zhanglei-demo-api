package com.zhangwenit.zhanglei.demo.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/26 7:56 AM
 * @Version 1.0
 **/
public class LoginResponse implements Serializable {

    @ApiModelProperty("登录账号名称")
    private String username;
    @ApiModelProperty(value = "账户类型 1=超级管理员  2=普通用户",dataType = "int",example = "1")
    private Integer type;
    @ApiModelProperty("token,需要登录后的其他请求放在head中，key为token")
    private String token;

    private static final long serialVersionUID = 1L;

    public LoginResponse(String username, Integer type, String token) {
        this.username = username;
        this.type = type;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "username='" + username + '\'' +
                ", type=" + type +
                ", token='" + token + '\'' +
                '}';
    }
}