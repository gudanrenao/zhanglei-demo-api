package com.zhangwenit.zhanglei.demo.api.dto;

import com.zhangwenit.zhanglei.demo.api.model.ThirdUser;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

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
    @ApiModelProperty("用户头像")
    private String headImg;
    @ApiModelProperty(value = "用户状态，1=正常  2=已冻结", example = "1")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public ThirdUserListDto() {
    }

    public ThirdUserListDto(ThirdUser thirdUser) {
        this.id = thirdUser.getId();
        this.nickName = thirdUser.getNickName();
        this.headImg = thirdUser.getHeadImg();
        this.state = thirdUser.getState();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
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
                ", headImg='" + headImg + '\'' +
                ", state=" + state +
                '}';
    }
}