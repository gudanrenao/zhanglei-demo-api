package com.zhangwenit.zhanglei.demo.api.dto.criteria;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/5/1 8:53 AM
 * @Version 1.0
 **/
@ApiModel("查询条件")
public class RestaurantCriteria extends BaseCriteria {

    @ApiModelProperty("饭店名称(模糊查询)")
    @Column(name = "name")
    private String restaurantName;
    @ApiModelProperty(value = "饭店状态，1=正常  2=已冻结", example = "1")
    private Integer state;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RestaurantCriteria{" +
                "restaurantName='" + restaurantName + '\'' +
                ", state=" + state +
                '}';
    }
}