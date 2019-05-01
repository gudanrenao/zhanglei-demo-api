package com.zhangwenit.zhanglei.demo.api.dto;

import com.zhangwenit.zhanglei.demo.api.model.Restaurant;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 5:35 PM
 * @Version 1.0
 **/
public class RestaurantListDto implements Serializable {

    @ApiModelProperty(value = "饭店id",example = "1")
    private Long id;
    @ApiModelProperty("饭店名称")
    private String name;
    @ApiModelProperty("饭店图片")
    private String picture;
    @ApiModelProperty(value = "饭店状态，1=正常  2=已冻结", example = "1")
    private Integer state;

    private static final long serialVersionUID = 1L;

    public RestaurantListDto() {
    }

    public RestaurantListDto(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.picture = restaurant.getPicture();
        this.state = restaurant.getState();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "RestaurantListDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", state=" + state +
                '}';
    }
}