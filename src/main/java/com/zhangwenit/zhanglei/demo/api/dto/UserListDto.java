package com.zhangwenit.zhanglei.demo.api.dto;

import com.zhangwenit.zhanglei.demo.api.model.PcManageUser;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/26 8:03 AM
 * @Version 1.0
 **/
public class UserListDto implements Serializable {

    @ApiModelProperty(value = "账号id",example = "1")
    private Long userId;
    @ApiModelProperty("登录账号名称")
    private String username;
    @ApiModelProperty(value = "账户类型 1=超级管理员  2=普通用户",dataType = "int",example = "1")
    private Integer type;
    @ApiModelProperty(value = "账户状态 1=正常  2=已冻结",dataType = "int",example = "1")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public UserListDto(PcManageUser user) {
        this.userId = user.getId();
        this.username = user.getName();
        this.type = user.getType();
        this.state = user.getState();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserListDto{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", type=" + type +
                ", state=" + state +
                '}';
    }
}