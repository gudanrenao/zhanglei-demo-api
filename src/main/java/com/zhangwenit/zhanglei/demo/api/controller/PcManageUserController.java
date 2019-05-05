package com.zhangwenit.zhanglei.demo.api.controller;

import com.zhangwenit.zhanglei.demo.api.constant.StateConstant;
import com.zhangwenit.zhanglei.demo.api.dto.LoginDto;
import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.dto.UserListDto;
import com.zhangwenit.zhanglei.demo.api.enums.CommonExceptionEnum;
import com.zhangwenit.zhanglei.demo.api.exception.CommonException;
import com.zhangwenit.zhanglei.demo.api.model.PcManageUser;
import com.zhangwenit.zhanglei.demo.api.service.PcManageUserService;
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
@Api(tags = "PC端账户管理相关接口")
public class PcManageUserController {

    private final PcManageUserService pcManageUserService;

    public PcManageUserController(PcManageUserService pcManageUserService) {
        this.pcManageUserService = pcManageUserService;
    }

    @ApiOperation(value = "获取账户列表", notes = "获取账户列表")
    @ApiResponses(@ApiResponse(code = 0, message = "", response = UserListDto.class))
    @PostMapping("/list")
    public ResponseVO list(@ApiIgnore @RequestAttribute PcManageUser user, @RequestHeader String token) {
        if (user.getType() != StateConstant.USER_TYPE_MANAGER) {
            throw new CommonException(CommonExceptionEnum.PERMISSION_DENIED);
        }
        return ResponseVO.buildSuccess(pcManageUserService.findAllUser().stream().map(UserListDto::new).collect(Collectors.toList()));
    }

    @ApiOperation(value = "冻结当前账号", notes = "冻结当前账号")
    @PostMapping("/freeze")
    public ResponseVO freeze(@ApiIgnore @RequestAttribute PcManageUser user, @RequestHeader String token, @ApiParam(value = "待冻结账号id", example = "1") @RequestParam Long userId) {
        pcManageUserService.freeze(user, userId);
        return ResponseVO.buildSuccess(true);
    }

    @ApiOperation(value = "激活当前账号", notes = "激活当前账号")
    @PostMapping("/active")
    public ResponseVO active(@ApiIgnore @RequestAttribute PcManageUser user, @RequestHeader String token, @ApiParam(value = "待激活账号id", example = "1") @RequestParam Long userId) {
        pcManageUserService.active(user, userId);
        return ResponseVO.buildSuccess(true);
    }

    @ApiOperation(value = "删除当前账号", notes = "删除当前账号")
    @DeleteMapping("/delete")
    public ResponseVO delete(@ApiIgnore @RequestAttribute PcManageUser user, @RequestHeader String token, @ApiParam(value = "待删除账号id", example = "1") @RequestParam Long userId) {
        pcManageUserService.delete(user, userId);
        return ResponseVO.buildSuccess(true);
    }

    @ApiOperation(value = "创建账号", notes = "创建账号")
    @PostMapping("/create")
    public ResponseVO create(@ApiIgnore @RequestAttribute PcManageUser user, @RequestHeader String token, @RequestBody LoginDto loginDto) {
        pcManageUserService.create(user, loginDto);
        return ResponseVO.buildSuccess(true);
    }
}