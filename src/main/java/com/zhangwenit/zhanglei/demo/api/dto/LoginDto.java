package com.zhangwenit.zhanglei.demo.api.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/25 7:33 PM
 * @Version 1.0
 **/
public class LoginDto {

    @ApiModelProperty("登录账号名称")
    private String username;
    @ApiModelProperty("登录账号密码")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String   toString() {
        return "LoginDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}