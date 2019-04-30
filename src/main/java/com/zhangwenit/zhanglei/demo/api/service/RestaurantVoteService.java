package com.zhangwenit.zhanglei.demo.api.service;

import com.zhangwenit.zhanglei.demo.api.dto.RestaurantVoteResultDto;
import com.zhangwenit.zhanglei.demo.api.dto.VoteRequest;
import com.zhangwenit.zhanglei.demo.api.exception.CommonException;
import com.zhangwenit.zhanglei.demo.api.model.Restaurant;
import com.zhangwenit.zhanglei.demo.api.model.RestaurantVote;
import com.zhangwenit.zhanglei.demo.api.model.ThirdUser;
import com.zhangwenit.zhanglei.demo.api.repository.RestaurantRepository;
import com.zhangwenit.zhanglei.demo.api.repository.RestaurantVoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/30 9:52 AM
 * @Version 1.0
 **/
@Service
public class RestaurantVoteService {

    private final RestaurantVoteRepository restaurantVoteRepository;
    private final RestaurantRepository restaurantRepository;
    private final TemplateFormService templateFormService;

    public RestaurantVoteService(RestaurantVoteRepository restaurantVoteRepository, RestaurantRepository restaurantRepository, TemplateFormService templateFormService) {
        this.restaurantVoteRepository = restaurantVoteRepository;
        this.restaurantRepository = restaurantRepository;
        this.templateFormService = templateFormService;
    }

    /**
     * 投票
     *
     * @param user
     * @param voteRequest
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void vote(final ThirdUser user, final VoteRequest voteRequest) {
        Assert.notNull(voteRequest.getRestaurantId(), "restaurantId can be not null");
        Restaurant restaurant = restaurantRepository.findById(voteRequest.getRestaurantId()).orElseThrow(() -> new CommonException("restaurant not found"));
        //判断今日是否已经投过票
        String today = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        RestaurantVote restaurantVote = restaurantVoteRepository.findByThirdUserIdAndAndRestaurant_IdAndVoteDate(user.getId(), restaurant.getId(), today);
        Assert.isNull(restaurantVote, "您今日已投过票");
        //添加今日投票
        restaurantVote = new RestaurantVote();
        restaurantVote.setRestaurant(restaurant);
        restaurantVote.setThirdUserId(user.getId());
        restaurantVote.setVoteDate(today);
        restaurantVoteRepository.save(restaurantVote);
        //添加formId
        templateFormService.addForm(user, voteRequest.getFormId());
    }

    /**
     * 获取今日投票结果
     *
     * @return
     */
    public Map<Long, RestaurantVoteResultDto> todayVoteResult() {
        String today = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        List<RestaurantVote> list = restaurantVoteRepository.findAllByVoteDate(today);
        Map<Long, RestaurantVoteResultDto> result = new HashMap<>(4);
        RestaurantVoteResultDto dto = null;
        for (RestaurantVote vote : list) {
            if (result.containsKey(vote.getRestaurant().getId())) {
                dto = result.get(vote.getRestaurant().getId());
                dto.setCount(dto.getCount() + 1);
            } else {
                dto = new RestaurantVoteResultDto(vote);
                result.put(vote.getRestaurant().getId(), dto);
            }
        }
        return result;
    }


}