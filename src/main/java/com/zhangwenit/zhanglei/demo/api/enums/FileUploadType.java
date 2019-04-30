package com.zhangwenit.zhanglei.demo.api.enums;

/**
 * @Description 文件上传类型
 * @Author ZWen
 * @Date 2018/11/6 3:56 PM
 * @Version 1.0
 **/
public enum FileUploadType {


    /**
     * 用户头像
     */
    USER_HEAD_IMG("zhanglei/user/"),
    /**
     * 饭店图片
     */
    RESTAURANT_IMG("zhanglei/restaurant/");


    /**
     * 上传路径前缀(域名与文件名之间)
     */
    private final String prefix;

    FileUploadType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
