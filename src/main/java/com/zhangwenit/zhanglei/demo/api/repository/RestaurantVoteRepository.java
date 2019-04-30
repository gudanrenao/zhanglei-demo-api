package com.zhangwenit.zhanglei.demo.api.repository;

import com.zhangwenit.zhanglei.demo.api.model.RestaurantVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author by zhangwen
 */
public interface RestaurantVoteRepository extends JpaRepository<RestaurantVote, Long> {


    List<RestaurantVote> findAllByVoteDate(String voteDate);

    RestaurantVote findByThirdUserIdAndAndRestaurant_IdAndVoteDate(Long thirdUserId, Long restaurantId,String voteDate);
}
