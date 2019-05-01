package com.zhangwenit.zhanglei.demo.api.controller.mini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/5/1 6:03 PM
 * @Version 1.0
 **/
@RestController
@ApiIgnore
@RequestMapping("/mini")
public class MiniCallbackController {

    private static final Logger logger = LoggerFactory.getLogger(MiniCallbackController.class);

    @GetMapping("/callback")
    public String callback(@RequestParam String signature, @RequestParam String timestamp,
                           @RequestParam String nonce, @RequestParam String echostr) {
        logger.info("callback检验:signature[{}],timestamp[{}],nonce[{}],echostr[{}]", signature, timestamp, nonce, echostr);
        return echostr;
    }
}