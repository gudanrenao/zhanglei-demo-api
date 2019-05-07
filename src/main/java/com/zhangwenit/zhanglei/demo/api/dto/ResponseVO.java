package com.zhangwenit.zhanglei.demo.api.dto;

import com.zhangwenit.zhanglei.demo.api.enums.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName ResponseVO
 * @Description
 * @Author XuQiuliang
 * @Date 2018/11/1 4:55 PM
 * @Version 1.0
 **/
@ApiModel(description = "响应对象")
public class ResponseVO<T> implements Serializable {

    @ApiModelProperty("响应头(错误码和错误原因)")
    private ResponseHeader head;
    @ApiModelProperty("响应数据")
    private T data;

    public ResponseVO() {
        this.head = new ResponseHeader(0, "");
    }

    public ResponseVO(ResultCode resultCode) {
        this.head = new ResponseHeader(resultCode);
    }

    public ResponseVO(Integer errCode, String errMsg) {
        this.head = new ResponseHeader(errCode, errMsg);
    }

    public ResponseVO(ResultCode resultCode, T data) {
        this.head = new ResponseHeader(resultCode);
        this.data = data;
    }

    public ResponseVO(T data, Integer errCode, String errMsg) {
        this.head = new ResponseHeader(errCode, errMsg);
        this.data = data;
    }

    public void setErrCode(Integer errCode) {
        head.setErrCode(errCode);
    }

    public void setErrMsg(String errMsg) {
        head.setErrMsg(errMsg);
    }

    public ResponseHeader getHead() {
        return this.head;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseVO<T> buildSuccess() {
        return new ResponseVO<>(ResultCode.SUCCESS);
    }

    public static <T> ResponseVO<T> buildSuccess(T data) {
        ResponseVO<T> responseVO = buildSuccess();
        responseVO.setData(data);
        return responseVO;
    }

    public static ResponseVO buildError(int errCode, String errMsg) {
        return new ResponseVO(errCode, errMsg);
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "head=" + head +
                ", data=" + data +
                '}';
    }
}
