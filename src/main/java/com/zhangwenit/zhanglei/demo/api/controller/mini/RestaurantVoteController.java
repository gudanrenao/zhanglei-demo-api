package com.zhangwenit.zhanglei.demo.api.controller.mini;

import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.dto.RestaurantVoteResultDto;
import com.zhangwenit.zhanglei.demo.api.dto.VoteRequest;
import com.zhangwenit.zhanglei.demo.api.model.ThirdUser;
import com.zhangwenit.zhanglei.demo.api.service.RestaurantVoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 5:39 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/restaurantVote")
@Api(tags = "饭店投票相关接口")
public class RestaurantVoteController {

    private final RestaurantVoteService restaurantVoteService;

    public RestaurantVoteController(RestaurantVoteService restaurantVoteService) {
        this.restaurantVoteService = restaurantVoteService;
    }

    @ApiOperation(value = "投票", notes = "投票")
    @PostMapping("/api-mini/vote")
    public ResponseVO vote(@ApiIgnore @RequestAttribute ThirdUser user, @RequestHeader String token, @RequestBody VoteRequest voteRequest) {
        restaurantVoteService.vote(user, voteRequest);
        return ResponseVO.buildSuccess();
    }

    @ApiOperation(value = "获取今日的投票结果", notes = "获取今日的投票结果")
    @ApiResponses(@ApiResponse(code = 0, message = "", response = RestaurantVoteResultDto.class))
    @PostMapping("/api-open/todayResult")
    public ResponseVO todayResult() {
        return ResponseVO.buildSuccess(restaurantVoteService.todayVoteResult());
    }
}