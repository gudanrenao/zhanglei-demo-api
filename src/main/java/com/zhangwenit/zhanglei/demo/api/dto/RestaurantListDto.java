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

    @ApiModelProperty(value = "id",example = "1")
    private Long id;
    @ApiModelProperty("饭店名称")
    private String name;
    @ApiModelProperty("饭店图片")
    private String picture;

    private static final long serialVersionUID = 1L;

    public RestaurantListDto() {
    }

    public RestaurantListDto(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.picture = restaurant.getPicture();
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
                '}';
    }
}