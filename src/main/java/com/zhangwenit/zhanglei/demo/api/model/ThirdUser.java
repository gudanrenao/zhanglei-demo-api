package com.zhangwenit.zhanglei.demo.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liqiuwei
 */
@Entity(name = "zl_third_user")
public class ThirdUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户真实姓名
     */
    private String name;
    /**
     * 用户头像
     */
    private String headImg;
    /**
     * 用户所在省
     */
    private String provinceName;
    /**
     * 用户所在市
     */
    private String cityName;
    /**
     * 状态 1、正常；2、注销
     */
    private Integer state;
    /**
     * 用户手机号
     */
    private String mobile;
    /**
     * 小程序openId
     */
    private String miniOpenId;
    /**
     * 公众号openId
     */
    private String publicOpenId;
    /**
     * 开放平台unionId
     */
    private String unionId;
    /**
     * 最后一次登录时间
     */
    private Date lastLoginTime;
    private String description;
    @Column(insertable = false)
    private Date createTime;
    private Date updateTime;

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

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMiniOpenId() {
        return miniOpenId;
    }

    public void setMiniOpenId(String miniOpenId) {
        this.miniOpenId = miniOpenId;
    }

    public String getPublicOpenId() {
        return publicOpenId;
    }

    public void setPublicOpenId(String publicOpenId) {
        this.publicOpenId = publicOpenId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ThirdUser{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", headImg='" + headImg + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", state=" + state +
                ", mobile='" + mobile + '\'' +
                ", miniOpenId='" + miniOpenId + '\'' +
                ", publicOpenId='" + publicOpenId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}