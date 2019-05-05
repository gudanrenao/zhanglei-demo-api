package com.zhangwenit.zhanglei.demo.api.dto;

import com.zhangwenit.zhanglei.demo.api.model.ThirdUser;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 5:35 PM
 * @Version 1.0
 **/
public class ThirdUserListDto implements Serializable {

    @ApiModelProperty(value = "用户id", example = "1")
    private Long id;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户头像")
    private String headImg;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("用户备注")
    private String description;
    @ApiModelProperty("最后登录时间")
    private Date lastLoginTime;
    @ApiModelProperty("用户公众号openId,如果为空，则无法给该用户发送模板消息")
    private String publicOpenId;
    @ApiModelProperty("用户小程序openId,如果为空，则无法给该用户发送服务通知")
    private String miniOpenId;
    @ApiModelProperty(value = "用户状态，1=正常  2=已冻结", example = "1")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public ThirdUserListDto() {
    }

    public ThirdUserListDto(ThirdUser thirdUser) {
        this.id = thirdUser.getId();
        this.nickName = thirdUser.getNickName();
        this.name = thirdUser.getName();
        this.mobile = thirdUser.getMobile();
        this.description = thirdUser.getDescription();
        this.lastLoginTime = thirdUser.getLastLoginTime();
        this.publicOpenId = thirdUser.getPublicOpenId();
        this.miniOpenId = thirdUser.getMiniOpenId();
        this.headImg = thirdUser.getHeadImg();
        this.state = thirdUser.getState();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNickName() {
        return nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getPublicOpenId() {
        return publicOpenId;
    }

    public void setPublicOpenId(String publicOpenId) {
        this.publicOpenId = publicOpenId;
    }

    public String getMiniOpenId() {
        return miniOpenId;
    }

    public void setMiniOpenId(String miniOpenId) {
        this.miniOpenId = miniOpenId;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ThirdUserListDto{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", headImg='" + headImg + '\'' +
                ", description='" + description + '\'' +
                ", mobile='" + mobile + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", publicOpenId='" + publicOpenId + '\'' +
                ", miniOpenId='" + miniOpenId + '\'' +
                ", state=" + state +
                '}';
    }
}