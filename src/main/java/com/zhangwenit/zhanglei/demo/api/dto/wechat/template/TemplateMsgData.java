package com.zhangwenit.zhanglei.demo.api.dto.wechat.template;

/**
 * @Description 基础Data
 * @Author ZWen
 * @Date 2018/12/26 3:50 PM
 * @Version 1.0
 **/
public class TemplateMsgData {

    private TemplateMsgRowData first;
    private TemplateMsgRowData remark;

    private TemplateMsgRowData keyword1;
    private TemplateMsgRowData keyword2;
    private TemplateMsgRowData keyword3;
    private TemplateMsgRowData keyword4;
    private TemplateMsgRowData keyword5;

    public TemplateMsgRowData getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(TemplateMsgRowData keyword1) {
        this.keyword1 = keyword1;
    }

    public TemplateMsgRowData getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(TemplateMsgRowData keyword2) {
        this.keyword2 = keyword2;
    }

    public TemplateMsgRowData getKeyword3() {
        return keyword3;
    }

    public TemplateMsgRowData getFirst() {
        return first;
    }

    public void setFirst(TemplateMsgRowData first) {
        this.first = first;
    }

    public TemplateMsgRowData getRemark() {
        return remark;
    }

    public void setRemark(TemplateMsgRowData remark) {
        this.remark = remark;
    }

    public void setKeyword3(TemplateMsgRowData keyword3) {
        this.keyword3 = keyword3;
    }

    public TemplateMsgRowData getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(TemplateMsgRowData keyword4) {
        this.keyword4 = keyword4;
    }

    public TemplateMsgRowData getKeyword5() {
        return keyword5;
    }

    public void setKeyword5(TemplateMsgRowData keyword5) {
        this.keyword5 = keyword5;
    }

    @Override
    public String toString() {
        return "TemplateMsgData{" +
                "first=" + first +
                ", remark=" + remark +
                ", keyword1=" + keyword1 +
                ", keyword2=" + keyword2 +
                ", keyword3=" + keyword3 +
                ", keyword4=" + keyword4 +
                ", keyword5=" + keyword5 +
                '}';
    }
}