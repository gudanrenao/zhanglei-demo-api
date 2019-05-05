package com.zhangwenit.zhanglei.demo.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description 更新用户信息
 * @Author ZWen
 * @Date 2019/5/5 6:52 PM
 * @Version 1.0
 **/
public class ThirdUserUpdateRequest implements Serializable {

    @ApiModelProperty(value = "用户id(不能为空)", example = "1")
    private Long id;
    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户头像")
    private String headImg;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("用户备注")
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ThirdUserUpdateRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headImg='" + headImg + '\'' +
                ", mobile='" + mobile + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}