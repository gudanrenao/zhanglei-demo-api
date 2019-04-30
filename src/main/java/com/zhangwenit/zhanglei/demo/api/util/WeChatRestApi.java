package com.zhangwenit.zhanglei.demo.api.util;

import com.zhangwenit.zhanglei.demo.api.constant.WeChatConstant;
import com.zhangwenit.zhanglei.demo.api.dto.wechat.CodeToSessionResponse;
import com.zhangwenit.zhanglei.demo.api.dto.wechat.MiniAccessTokenResponse;
import com.zhangwenit.zhanglei.demo.api.dto.wechat.TemplateMsgRequest;
import com.zhangwenit.zhanglei.demo.api.dto.wechat.WeChatBaseResponse;
import com.zhangwenit.zhanglei.demo.api.exception.CommonException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 微信相关接口
 * @Author ZWen
 * @Date 2019/4/30 2:05 PM
 * @Version 1.0
 **/
@Component
public class WeChatRestApi {

    @Value("${mini.appId}")
    private String appId;
    @Value("${mini.secret}")
    private String secret;

    private final RestTemplate restTemplate;

    public WeChatRestApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 获取小程序全局唯一后台接口调用凭据（access_token）
     *
     * @return
     */
    public MiniAccessTokenResponse getMiniAccessToken() {
        MiniAccessTokenResponse response = restTemplate.getForObject(WeChatConstant.MINI_ACCESS_TOKEN_URL, MiniAccessTokenResponse.class, commonParams());
        if (response == null || response.getErrCode() != 0) {
            throw new CommonException(response != null ? response.getErrCode() + response.getErrMsg() : "getMiniAccessToken error");
        }
        return response;
    }

    /**
     * 登录凭证校验
     *
     * @return
     */
    public CodeToSessionResponse miniCodeToSession(String code) {
        Map<String, Object> requestMap = commonParams();
        requestMap.put("code", code);
        CodeToSessionResponse response = restTemplate.getForObject(WeChatConstant.CODE_2_SESSION_URL, CodeToSessionResponse.class, requestMap);
        if (response == null || response.getErrCode() != 0) {
            throw new CommonException(response != null ? response.getErrCode() + response.getErrMsg() : "miniCodeToSession error");
        }
        return response;
    }

    /**
     * 发送小程序模板消息
     *
     * @param request
     * @return
     */
    public WeChatBaseResponse sendMiniTemplateMsg(TemplateMsgRequest request) {
        WeChatBaseResponse response = restTemplate.postForObject(WeChatConstant.MINI_SEND_TEMPLATE_URL, request, WeChatBaseResponse.class, request.getAccessToken());
        if (response == null || response.getErrCode() != 0) {
            throw new CommonException(response != null ? response.getErrCode() + response.getErrMsg() : "sendMiniTemplateMsg error");
        }
        return response;
    }

    private Map<String, Object> commonParams() {
        Map<String, Object> requestMap = new HashMap<>(8);
        requestMap.put("appId", appId);
        requestMap.put("secret", secret);
        return requestMap;
    }
}