package com.zhangwenit.zhanglei.demo.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 发送模板消息的表单id
 *
 * @author zw
 */
@Entity(name = "zl_template_form")
public class TemplateForm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * formId
     */
    private String formId;
    /**
     * formId对应的用户openId
     */
    private String openId;
    /**
     * formId使用状态 1=待使用  2=已使用
     */
    private Integer state;
    @Column(insertable = false)
    private Date createTime;
    /**
     * 使用时间
     */
    private Date useTime;
    /**
     * 描述，使用异常原因等
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TemplateForm{" +
                "id=" + id +
                ", formId='" + formId + '\'' +
                ", openId='" + openId + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", useTime=" + useTime +
                ", description='" + description + '\'' +
                '}';
    }
}
