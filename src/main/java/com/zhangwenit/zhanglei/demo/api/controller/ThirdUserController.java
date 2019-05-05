package com.zhangwenit.zhanglei.demo.api.controller;

import com.zhangwenit.zhanglei.demo.api.dto.*;
import com.zhangwenit.zhanglei.demo.api.dto.criteria.ThirdUserCriteria;
import com.zhangwenit.zhanglei.demo.api.model.PcManageUser;
import com.zhangwenit.zhanglei.demo.api.service.ThirdUserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 7:05 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/thirdUser")
@Api(tags = "小程序用户相关接口")
public class ThirdUserController {

    private final ThirdUserService thirdUserService;

    public ThirdUserController(ThirdUserService thirdUserService) {
        this.thirdUserService = thirdUserService;
    }

    @ApiOperation(value = "小程序登录", notes = "小程序登录")
    @ApiResponses(@ApiResponse(code = 0, message = "", response = ThirdUserDto.class))
    @PostMapping("/api-mini/login")
    public ResponseVO loginWx(@RequestBody MiniLoginUser user) throws Exception {
        return ResponseVO.buildSuccess(thirdUserService.login(user));
    }

    @ApiOperation(value = "分页条件查询用户列表", notes = "分页条件查询用户列表")
    @ApiResponses(@ApiResponse(code = 0, message = "", response = ThirdUserListDto.class))
    @PostMapping("/api/list")
    public ResponseVO list(@RequestBody ThirdUserCriteria criteria, @RequestHeader String token) {
        return ResponseVO.buildSuccess(thirdUserService.findByCriteria(criteria));
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @PutMapping("/api/update")
    public ResponseVO update(@RequestHeader String token, @RequestBody ThirdUserUpdateRequest updateRequest) {
        thirdUserService.update(updateRequest);
        return ResponseVO.buildSuccess(true);
    }

    @ApiOperation(value = "冻结当前用户", notes = "冻结当前用户")
    @PutMapping("/api/freeze")
    public ResponseVO freeze(@ApiIgnore @RequestAttribute PcManageUser user, @RequestHeader String token, @ApiParam(value = "待冻结用户id", example = "1") @RequestParam Long restaurantId) {
        thirdUserService.freeze(user, restaurantId);
        return ResponseVO.buildSuccess(true);
    }

    @ApiOperation(value = "激活当前用户", notes = "激活当前用户")
    @PutMapping("/api/active")
    public ResponseVO active(@ApiIgnore @RequestAttribute PcManageUser user, @RequestHeader String token, @ApiParam(value = "待激活用户id", example = "1") @RequestParam Long restaurantId) {
        thirdUserService.active(user, restaurantId);
        return ResponseVO.buildSuccess(true);
    }
}