package com.zhangwenit.zhanglei.demo.api.dto;

import com.zhangwenit.zhanglei.demo.api.enums.ResultCode;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName ResponseHeader
 * @Author ZWen
 * @Date 2018/11/6 5:40 PM
 * @Version 1.0
 **/
public class ResponseHeader implements Serializable {

    @ApiModelProperty(value = "错误码",example = "10001")
    private int errCode;

    private String errMsg;

    public ResponseHeader() {
    }

    public ResponseHeader(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ResponseHeader(ResultCode resultCode) {
        this.errCode = resultCode.getIndex();
        this.errMsg = resultCode.getDesc();
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ResponseHeader{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}