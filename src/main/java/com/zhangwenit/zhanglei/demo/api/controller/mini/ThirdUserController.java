package com.zhangwenit.zhanglei.demo.api.controller.mini;

import com.zhangwenit.zhanglei.demo.api.dto.MiniLoginUser;
import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.dto.ThirdUserDto;
import com.zhangwenit.zhanglei.demo.api.service.ThirdUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 7:05 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api-mini/user")
@Api(tags = "小程序用户相关接口")
public class ThirdUserController {

    private final ThirdUserService thirdUserService;

    public ThirdUserController(ThirdUserService thirdUserService) {
        this.thirdUserService = thirdUserService;
    }

    @ApiOperation(value = "小程序登录", notes = "小程序登录")
    @ApiResponses(@ApiResponse(code = 0, message = "", response = ThirdUserDto.class))
    @PostMapping("/login")
    public ResponseVO loginWx(@RequestBody MiniLoginUser user) throws Exception {
        return ResponseVO.buildSuccess(thirdUserService.login(user));
    }
}