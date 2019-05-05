package com.zhangwenit.zhanglei.demo.api.dto;

import com.zhangwenit.zhanglei.demo.api.model.ThirdUser;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 7:24 PM
 * @Version 1.0
 **/
public class ThirdUserDto implements Serializable {

    @ApiModelProperty("token,需要登录后的其他请求放在head中，key为token")
    private String token;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("用户真实姓名")
    private String name;
    @ApiModelProperty("用户头像")
    private String headImg;
    @ApiModelProperty("用户手机号")
    private String mobile;
    @ApiModelProperty("小程序openId")
    private String openId;
    @ApiModelProperty("用户描述")
    private String description;

    public ThirdUserDto() {
    }

    public ThirdUserDto(String token, ThirdUser user) {
        this.token = token;
        this.nickName = user.getNickName();
        this.name = user.getName();
        this.headImg = user.getHeadImg();
        this.mobile = user.getMobile();
        this.openId = user.getMiniOpenId();
        this.description = user.getDescription();
    }

    private static final long serialVersionUID = 1L;

    public String getNickName() {
        return nickName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ThirdUserDto{" +
                "token='" + token + '\'' +
                "nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", headImg='" + headImg + '\'' +
                ", mobile='" + mobile + '\'' +
                ", openId='" + openId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}