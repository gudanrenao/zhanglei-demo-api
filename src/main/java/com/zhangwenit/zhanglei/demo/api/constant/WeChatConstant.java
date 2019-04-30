package com.zhangwenit.zhanglei.demo.api.constant;

/**
 * @Description 微信相关常量
 * @Author ZWen
 * @Date 2019/4/29 11:19 PM
 * @Version 1.0
 **/
public interface WeChatConstant {

    String MINI_ACCESS_TOKEN_REDIS_KEY = "mini:accessToken";
    int MINI_ACCESS_TOKEN_REDIS_EXPIRE_SECOND = 120 * 60;

    String URL_PREFIX = "https://api.weixin.qq.com/";

    String CODE_2_SESSION_URL = URL_PREFIX + "sns/jscode2sessio?grant_type=authorization_code&appid={appId}&secret={secret}&js_code={code}";
    String MINI_ACCESS_TOKEN_URL = URL_PREFIX + "cgi-bin/token?grant_type=client_credential&appid={appId}&secret={secret}";
    String MINI_SEND_TEMPLATE_URL = URL_PREFIX + "cgi-bin/message/wxopen/template/send?access_token={accessToken}";
}
