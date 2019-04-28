package com.zhangwenit.zhanglei.demo.api.controller;

import com.zhangwenit.zhanglei.demo.api.dto.LoginDto;
import com.zhangwenit.zhanglei.demo.api.dto.LoginResponse;
import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.model.User;
import com.zhangwenit.zhanglei.demo.api.service.RedisService;
import com.zhangwenit.zhanglei.demo.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/25 7:30 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/login")
@Api(tags = "登录相关接口")
public class LoginController {

    private final UserService userService;
    private final RedisService redisService;

    public LoginController(UserService userService, RedisService redisService) {
        this.userService = userService;
        this.redisService = redisService;
    }

    @ApiOperation(value = "登录", notes = "登录")
    @ApiResponse(code = 0, message = "", response = LoginResponse.class)
    @PostMapping("/loginIn")
    public ResponseVO loginIn(@RequestBody LoginDto loginDto) {
        if (StringUtils.isEmpty(loginDto.getUsername()) || StringUtils.isEmpty(loginDto.getPassword())) {
            return ResponseVO.buildError(1001, "登录名或密码为空");
        }
        User user = userService.findByName(loginDto.getUsername());
        if (user == null) {
            return ResponseVO.buildError(1001, "登录名或密码错误");
        }
        if (user.getState() == 2) {
            return ResponseVO.buildError(1001, "账户以被冻结");
        }
        if (!DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes()).equals(user.getPassword())) {
            return ResponseVO.buildError(1001, "登录名或密码错误");
        }
        //登录成功，将登录信息保存到redis
        String token = redisService.setLoginInfo(user);
        return ResponseVO.buildSuccess(new LoginResponse(user.getName(), user.getType(), token));
    }

    @ApiOperation(value = "退出登录", notes = "退出登录")
    @PostMapping("/loginOut")
    public ResponseVO loginOut(@RequestHeader String token) {
        redisService.delToken(token);
        return ResponseVO.buildSuccess();
    }
}