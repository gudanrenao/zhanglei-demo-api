package com.zhangwenit.zhanglei.demo.api.controller;

import com.zhangwenit.zhanglei.demo.api.constant.StateConstant;
import com.zhangwenit.zhanglei.demo.api.dto.LoginDto;
import com.zhangwenit.zhanglei.demo.api.dto.LoginResponse;
import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.enums.CommonExceptionEnum;
import com.zhangwenit.zhanglei.demo.api.exception.CommonException;
import com.zhangwenit.zhanglei.demo.api.model.PcManageUser;
import com.zhangwenit.zhanglei.demo.api.service.RedisService;
import com.zhangwenit.zhanglei.demo.api.service.PcManageUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(tags = "PC端登录相关接口")
public class LoginController {

    private final PcManageUserService pcManageUserService;
    private final RedisService redisService;

    public LoginController(PcManageUserService pcManageUserService, RedisService redisService) {
        this.pcManageUserService = pcManageUserService;
        this.redisService = redisService;
    }

    @ApiOperation(value = "登录", notes = "登录")
    @ApiResponses(@ApiResponse(code = 0, message = "", response = LoginResponse.class))
    @PostMapping("/loginIn")
    public ResponseVO<LoginResponse> loginIn(@RequestBody LoginDto loginDto) {
        if (StringUtils.isEmpty(loginDto.getUsername()) || StringUtils.isEmpty(loginDto.getPassword())) {
            throw new CommonException(CommonExceptionEnum.NAMNE_OR_PWD_ERROR);
        }
        PcManageUser user = pcManageUserService.findByName(loginDto.getUsername());
        if (user == null) {
            throw new CommonException(CommonExceptionEnum.NAMNE_OR_PWD_ERROR);
        }
        if (user.getState() == StateConstant.USER_STATE_FREEZE) {
            throw new CommonException(CommonExceptionEnum.USER_FREEZE);
        }
        if (!DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes()).equals(user.getPassword())) {
            throw new CommonException(CommonExceptionEnum.NAMNE_OR_PWD_ERROR);
        }
        //登录成功，将登录信息保存到redis
        String token = redisService.setLoginInfo(user);
        return ResponseVO.buildSuccess(new LoginResponse(user.getName(), user.getType(), token));
    }

    @ApiOperation(value = "退出登录", notes = "退出登录")
    @PostMapping("/loginOut")
    public ResponseVO loginOut(@RequestHeader String token) {
        redisService.delToken(token);
        return ResponseVO.buildSuccess(true);
    }
}