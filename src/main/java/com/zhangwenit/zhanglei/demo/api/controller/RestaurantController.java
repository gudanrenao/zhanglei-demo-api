package com.zhangwenit.zhanglei.demo.api.controller;

import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.dto.RestaurantListDto;
import com.zhangwenit.zhanglei.demo.api.dto.criteria.RestaurantCriteria;
import com.zhangwenit.zhanglei.demo.api.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 5:39 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/restaurant")
@Api(tags = "饭店相关接口")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @ApiOperation(value = "获取所有的正常的饭店列表", notes = "获取所有的正常的饭店列表")
    @ApiResponses(@ApiResponse(code = 0, message = "", response = RestaurantListDto.class))
    @GetMapping("/api-open/list")
    public ResponseVO list() {
        return ResponseVO.buildSuccess(restaurantService.findAllNormalRestaurant());
    }

    @ApiOperation(value = "分页条件查询饭店列表", notes = "分页条件查询饭店列表")
    @ApiResponses(@ApiResponse(code = 0, message = "", response = RestaurantListDto.class))
    @PostMapping("/api/list")
    public ResponseVO list(@RequestBody RestaurantCriteria criteria, @RequestHeader String token) {
        return ResponseVO.buildSuccess(restaurantService.findByCriteria(criteria));
    }
}