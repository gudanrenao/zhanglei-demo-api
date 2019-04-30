package com.zhangwenit.zhanglei.demo.api.dto.wechat.template;

/**
 * @Description 数据
 * @Author ZWen
 * @Date 2018/12/26 4:30 PM
 * @Version 1.0
 **/
public class TemplateMsgRowData {

    /**
     * 模板内容
     */
    private String value;
    /**
     * 模板内容字体颜色，不填默认为黑色
     */
    private String color;

    public TemplateMsgRowData(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public TemplateMsgRowData(String value) {
        this.value = value;
    }

    public TemplateMsgRowData() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "TemplateMsgRowData{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}