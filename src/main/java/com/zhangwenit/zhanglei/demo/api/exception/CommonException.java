package com.zhangwenit.zhanglei.demo.api.exception;

import com.zhangwenit.zhanglei.demo.api.enums.CommonExceptionEnum;
import com.zhangwenit.zhanglei.demo.api.enums.ResultCode;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/28 5:57 PM
 * @Version 1.0
 **/
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 6409874889208817528L;
    private final CommonExceptionEnum commonExceptionEnum;
    private String message;

    public CommonException(CommonExceptionEnum commonExceptionEnum, Object... params) {
        this.commonExceptionEnum = commonExceptionEnum;
        if (ArrayUtils.isEmpty(params)) {
            this.message = commonExceptionEnum.getDesc();
        } else {
            this.message = String.format(commonExceptionEnum.getDesc(), params);
        }

    }

    public CommonException(String message) {
        this.commonExceptionEnum = null;
        this.message = message;
    }

    public int getResultCode() {
        return this.commonExceptionEnum == null ? ResultCode.FAILED.getIndex() : this.commonExceptionEnum.value;
    }

    public String getMessage() {
        if (this.commonExceptionEnum == null) {
            return this.getMsg();
        } else {
            StringBuilder exMessage = new StringBuilder();
            exMessage.append("code: ");
            exMessage.append(this.commonExceptionEnum.value);
            exMessage.append("; message: ");
            exMessage.append(this.getMsg());
            return exMessage.toString();
        }
    }

    public String getMsg() {
        return this.message;
    }
}