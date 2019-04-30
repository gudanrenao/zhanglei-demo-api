package com.zhangwenit.zhanglei.demo.api.dto;

import com.zhangwenit.zhanglei.demo.api.model.RestaurantVote;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 投票结果
 *
 * @author zhangwen at 2018-08-15 22:52
 **/
public class RestaurantVoteResultDto implements Serializable {

    @ApiModelProperty("投票时间，yyyy-MM-dd")
    private String voteDate;
    @ApiModelProperty(value = "饭店id", example = "1")
    private Long restaurantId;
    @ApiModelProperty("饭店名称")
    private String restaurantName;
    @ApiModelProperty("饭店图片")
    private String restaurantPicture;
    @ApiModelProperty(value = "投票次数", example = "0")
    private int count = 1;

    public RestaurantVoteResultDto() {
    }

    public RestaurantVoteResultDto(RestaurantVote vote) {
        this.voteDate = vote.getVoteDate();
        this.restaurantId = vote.getRestaurant().getId();
        this.restaurantName = vote.getRestaurant().getName();
        this.restaurantPicture = vote.getRestaurant().getPicture();
    }

    private static final long serialVersionUID = 1L;

    public String getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(String voteDate) {
        this.voteDate = voteDate;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantPicture() {
        return restaurantPicture;
    }

    public void setRestaurantPicture(String restaurantPicture) {
        this.restaurantPicture = restaurantPicture;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "RestaurantVoteResultDto{" +
                "voteDate='" + voteDate + '\'' +
                ", restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantPicture='" + restaurantPicture + '\'' +
                ", count=" + count +
                '}';
    }
}
