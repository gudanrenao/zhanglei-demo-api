package com.zhangwenit.zhanglei.demo.api.dto.wechat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zhangwenit.zhanglei.demo.api.dto.wechat.template.TemplateMsgData;

import java.io.Serializable;

/**
 * @Description 发送小程序模板消息请求体数据
 * @Author ZWen
 * @Date 2019/1/7 1:48 PM
 * @Version 1.0
 **/
public class TemplateMsgRequest implements Serializable {

    @JsonProperty("access_token")
    private String accessToken;
    /**
     * 接收者（用户）的 openid
     */
    @JsonProperty("touser")
    private String openId;
    /**
     * 所需下发的模板消息的id
     */
    @JsonProperty("template_id")
    private String templateId;
    /**
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转
     */
    private String page;
    /**
     * 表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
     */
    @JsonProperty("form_id")
    private String formId;
    /**
     * 模板需要放大的关键词，不填则默认无放大
     */
    @JsonProperty("emphasis_keyword")
    private String emphasisKeyword;
    /**
     * 模板内容，不填则下发空模板
     */
    private TemplateMsgData data;

    private static final long serialVersionUID = 1L;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getPage() {
        return page;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getEmphasisKeyword() {
        return emphasisKeyword;
    }

    public void setEmphasisKeyword(String emphasisKeyword) {
        this.emphasisKeyword = emphasisKeyword;
    }

    public TemplateMsgData getData() {
        return data;
    }

    public void setData(TemplateMsgData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TemplateMsgRequest{" +
                "accessToken='" + accessToken + '\'' +
                "openId='" + openId + '\'' +
                ", templateId='" + templateId + '\'' +
                ", page='" + page + '\'' +
                ", formId='" + formId + '\'' +
                ", emphasisKeyword='" + emphasisKeyword + '\'' +
                ", data=" + data +
                '}';
    }
}