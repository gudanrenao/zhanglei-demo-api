package com.zhangwenit.zhanglei.demo.api.dto.criteria;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/5/1 8:53 AM
 * @Version 1.0
 **/
@ApiModel("查询条件")
public class ThirdUserCriteria extends BaseCriteria {

    @ApiModelProperty(value = "用户昵称(模糊查询)", example = "张")
    private String nickname;
    @ApiModelProperty(value = "用户状态，1=正常  2=已冻结", example = "1")
    private Integer state;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ThirdUserCriteria{" +
                "nickname='" + nickname + '\'' +
                ", state=" + state +
                '}';
    }
}