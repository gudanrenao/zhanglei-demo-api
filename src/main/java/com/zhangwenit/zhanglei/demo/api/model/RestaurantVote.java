package com.zhangwenit.zhanglei.demo.api.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 投票结果
 *
 * @author zhangwen at 2018-08-15 22:52
 **/
@Entity(name = "zl_restaurant_vote")
public class RestaurantVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 投票时间，yyyy-MM-dd
     */
    private String voteDate;
    /**
     * 投票饭店
     */
    @ManyToOne
    private Restaurant restaurant;
    /**
     * 投票人id
     */
    private Long thirdUserId;
    @Column(insertable = false)
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(String voteDate) {
        this.voteDate = voteDate;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getThirdUserId() {
        return thirdUserId;
    }

    public void setThirdUserId(Long thirdUserId) {
        this.thirdUserId = thirdUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RestaurantVote{" +
                "id=" + id +
                ", voteDate='" + voteDate + '\'' +
                ", restaurant=" + restaurant +
                ", thirdUserId=" + thirdUserId +
                ", createTime=" + createTime +
                '}';
    }
}
