package com.zhangwenit.zhanglei.demo.api.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName FileUploadUtil
 * @Description 文件上传工具类
 * @Author ZWen
 * @Date 2018/11/6 2:15 PM
 * @Version 1.0
 **/
public class FileUploadUtil {

    public static final String LETTER_OR_NUM = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public static final String DATE_TIME_FORMAT_1 = "yyyyMMddHHmmss";

    /**
     * 随机生成没有文件后缀有前缀的文件名
     *
     * @param prefix 前缀
     * @return
     */
    public static String getFileName(String prefix) {
        String randomStr = RandomStringUtils.random(2, LETTER_OR_NUM);
        return prefix + new SimpleDateFormat(DATE_TIME_FORMAT_1).format(new Date()) + randomStr;
    }

    /**
     * 获取文件名后缀
     *
     * @param fullName 完整文件名
     * @return
     */
    public static String getExtendedName(String fullName) {
        if (fullName != null) {
            String[] arr = fullName.split("\\.");
            return arr[arr.length - 1];
        }
        return null;
    }
}