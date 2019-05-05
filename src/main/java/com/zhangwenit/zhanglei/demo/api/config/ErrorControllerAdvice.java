package com.zhangwenit.zhanglei.demo.api.config;

import com.zhangwenit.zhanglei.demo.api.dto.ResponseVO;
import com.zhangwenit.zhanglei.demo.api.enums.ResultCode;
import com.zhangwenit.zhanglei.demo.api.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName ErrorControllerAdvice
 * @Description 统一异常处理
 * @Author ZWen
 * @Date 2018/11/7 4:59 PM
 * @Version 1.0
 **/
@RestControllerAdvice
public class ErrorControllerAdvice {

    private final static Logger logger = LoggerFactory.getLogger(ErrorControllerAdvice.class);

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseVO handle(RuntimeException e) {
        logger.error("Handle RuntimeException", e);
        return new ResponseVO(ResultCode.ERROR.getIndex(),e.getMessage());
    }

    @ExceptionHandler(value = CommonException.class)
    public ResponseVO handle(CommonException e) {
        logger.error("Handle CommonException", e);
        return ResponseVO.buildError(e.getResultCode(), e.getMsg());
    }
}