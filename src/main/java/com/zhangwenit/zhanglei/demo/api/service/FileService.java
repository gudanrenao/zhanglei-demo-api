package com.zhangwenit.zhanglei.demo.api.service;

import com.aliyun.oss.OSSClient;
import com.zhangwenit.zhanglei.demo.api.config.OssClientConfig;
import com.zhangwenit.zhanglei.demo.api.enums.FileUploadType;
import com.zhangwenit.zhanglei.demo.api.util.FileUploadUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description 文件/图片 上传下载等操作
 * @Author ZWen
 * @Date 2019/4/30 5:25 PM
 * @Version 1.0
 **/
@Service
public class FileService {

    private final OSSClient ossClient;
    private final OssClientConfig.OssProperties ossProperties;

    public FileService(OSSClient ossClient, OssClientConfig.OssProperties ossProperties) {
        this.ossClient = ossClient;
        this.ossProperties = ossProperties;
    }

    /**
     * 文件或图片上传
     *
     * @param file
     * @param fileUploadType
     * @return
     */
    public String uploadFile(MultipartFile file, FileUploadType fileUploadType) throws IOException {
        String fileName = FileUploadUtil.getFileName(fileUploadType.getPrefix());
        String oriName = file.getOriginalFilename();
        String extendName = FileUploadUtil.getExtendedName(oriName);
        //完整的文件及路径(不带域名)
        String fullNameWithPath = fileName + "." + extendName;
        ossClient.putObject(ossProperties.getBucket(), fullNameWithPath, file.getInputStream());
        return ossProperties.getDomainName() + fullNameWithPath;
    }
}