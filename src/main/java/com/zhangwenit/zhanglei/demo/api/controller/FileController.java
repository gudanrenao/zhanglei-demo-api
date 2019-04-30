package com.zhangwenit.zhanglei.demo.api.controller;

import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.enums.FileUploadType;
import com.zhangwenit.zhanglei.demo.api.service.FileService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName FileController
 * @Description 文件/图片上传下载相关接口
 * @Author ZWen
 * @Date 2018/11/6 3:56 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/file")
@Api(tags = "文件or图片上传or下载接口")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/api/upload")
    @ApiOperation(value = "文件或图片上传", notes = "文件或图片上传")
    @ApiResponses(value = {@ApiResponse(code = 0, message = "")})
    public ResponseVO upload(@RequestParam("file") MultipartFile file, @ApiParam("上传文件类型") @RequestParam FileUploadType fileUploadType, @RequestHeader String token) throws IOException {
        String fileUrl = fileService.uploadFile(file, fileUploadType);
        return ResponseVO.buildSuccess(fileUrl);
    }

}