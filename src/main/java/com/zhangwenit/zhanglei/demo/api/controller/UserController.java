package com.zhangwenit.zhanglei.demo.api.controller;

import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.dto.UserListDto;
import com.zhangwenit.zhanglei.demo.api.model.User;
import com.zhangwenit.zhanglei.demo.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @PostMapping("/list")
    public ResponseVO loginIn(@ApiIgnore @RequestAttribute User user, @RequestHeader String token) {
        if (user.getType() != 1) {
            return ResponseVO.buildError(1002, "账户无权限(需要使用管理员账户)");
        }
        return ResponseVO.buildSuccess(userService.findAllUser().stream().map(UserListDto::new).collect(Collectors.toList()));
    }
}