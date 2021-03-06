package com.zhangwenit.zhanglei.demo.api.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/30 11:00 AM
 * @Version 1.0
 **/
public class VoteRequest {

    @ApiModelProperty(value = "投票饭店id", example = "1")
    private Long restaurantId;
    @ApiModelProperty("formId")
    private String formId;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "VoteRequest{" +
                "restaurantId=" + restaurantId +
                ", formId='" + formId + '\'' +
                '}';
    }
}