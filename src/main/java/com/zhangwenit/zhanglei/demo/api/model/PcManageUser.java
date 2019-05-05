package com.zhangwenit.zhanglei.demo.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * pc后台登录用户
 *
 * @author zhangwen at 2018-08-15 22:52
 **/
@Entity(name = "zl_pc_manage_user")
public class PcManageUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    /**
     * 账户类型 1=超级管理员  2=普通用户
     */
    private Integer type;
    /**
     * 账户状态 1=正常  2=已冻结
     */
    private Integer state;
    /**
     * 是否已删除 1=已删除  0=未删除
     */
    private Integer isDelete;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PcManageUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", isDelete=" + isDelete +
                ", updateTime=" + updateTime +
                '}';
    }
}
