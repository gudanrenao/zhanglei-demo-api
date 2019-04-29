package com.zhangwenit.zhanglei.demo.api.controller.open;

import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.dto.RestaurantListDto;
import com.zhangwenit.zhanglei.demo.api.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 5:39 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api-open/restaurant")
@Api(tags = "饭店相关开放接口(无需登录)")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @ApiOperation(value = "获取所有的正常的饭店列表", notes = "获取所有的正常的饭店列表")
    @ApiResponses(@ApiResponse(code = 0, message = "", response = RestaurantListDto.class))
    @PostMapping("/list")
    public ResponseVO list() {
        return ResponseVO.buildSuccess(restaurantService.findAllNormalRestaurant());
    }
}