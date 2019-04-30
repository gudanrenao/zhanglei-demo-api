package com.zhangwenit.zhanglei.demo.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 饭店表
 *
 * @author zhangwen at 2018-08-15 22:52
 **/
@Entity(name = "zl_restaurant")
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 饭店名称
     */
    private String name;
    /**
     * 图片
     */
    private String picture;
    /**
     * 饭店状态 1=正常  2=已删除
     */
    private Integer state;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", state=" + state +
                '}';
    }
}
