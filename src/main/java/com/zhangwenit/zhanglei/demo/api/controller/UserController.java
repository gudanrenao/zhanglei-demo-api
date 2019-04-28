package com.zhangwenit.zhanglei.demo.api.controller;

import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.dto.UserListDto;
import com.zhangwenit.zhanglei.demo.api.enums.CommonExceptionEnum;
import com.zhangwenit.zhanglei.demo.api.exception.CommonException;
import com.zhangwenit.zhanglei.demo.api.model.User;
import com.zhangwenit.zhanglei.demo.api.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.stream.Collectors;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/26 8:00 AM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/user")
@Api(tags = "账户管理相关接口")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "获取账户列表", notes = "获取账户列表")
    @ApiResponses(@ApiResponse(code = 0, message = "", response = UserListDto.class))
    @PostMapping("/list")
    public ResponseVO list(@ApiIgnore @RequestAttribute User user, @RequestHeader String token) {
        if (user.getType() != 1) {
            throw new CommonException(CommonExceptionEnum.PERMISSION_DENIED);
        }
        return ResponseVO.buildSuccess(userService.findAllUser().stream().map(UserListDto::new).collect(Collectors.toList()));
    }

    @ApiOperation(value = "冻结当前账号", notes = "冻结当前账号")
    @PostMapping("/freeze")
    public ResponseVO freeze(@ApiIgnore @RequestAttribute User user, @RequestHeader String token, @ApiParam("待冻结账号id") @RequestParam Long userId) {
        userService.freeze(user, userId);
        return ResponseVO.buildSuccess();
    }

    @ApiOperation(value = "激活当前账号", notes = "激活当前账号")
    @PostMapping("/active")
    public ResponseVO active(@ApiIgnore @RequestAttribute User user, @RequestHeader String token, @ApiParam("待激活账号id") @RequestParam Long userId) {
        userService.active(user, userId);
        return ResponseVO.buildSuccess();
    }
}