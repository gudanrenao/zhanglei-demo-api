package com.zhangwenit.zhanglei.demo.api.controller;

import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.dto.RestaurantListDto;
import com.zhangwenit.zhanglei.demo.api.dto.RestaurantSaveRequest;
import com.zhangwenit.zhanglei.demo.api.dto.criteria.RestaurantCriteria;
import com.zhangwenit.zhanglei.demo.api.model.User;
import com.zhangwenit.zhanglei.demo.api.service.RestaurantService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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

    @ApiOperation(value = "冻结当前饭店", notes = "冻结当前饭店")
    @PostMapping("/api/freeze")
    public ResponseVO freeze(@ApiIgnore @RequestAttribute User user, @RequestHeader String token, @ApiParam(value = "待冻结饭店id", example = "1") @RequestParam Long restaurantId) {
        restaurantService.freeze(user, restaurantId);
        return ResponseVO.buildSuccess(true);
    }

    @ApiOperation(value = "激活当前饭店", notes = "激活当前饭店")
    @PostMapping("/api/active")
    public ResponseVO active(@ApiIgnore @RequestAttribute User user, @RequestHeader String token, @ApiParam(value = "待激活饭店id", example = "1") @RequestParam Long restaurantId) {
        restaurantService.active(user, restaurantId);
        return ResponseVO.buildSuccess(true);
    }

    @ApiOperation(value = "创建或编辑饭店", notes = "创建或编辑饭店")
    @PostMapping("/api/submit")
    public ResponseVO active(@ApiIgnore @RequestAttribute User user, @RequestHeader String token, @RequestBody RestaurantSaveRequest saveRequest) {
        restaurantService.submit(user, saveRequest);
        return ResponseVO.buildSuccess(true);
    }
}