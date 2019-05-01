package com.zhangwenit.zhanglei.demo.api.dto.criteria;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 分页查询条件
 * @Author ZWen
 * @Date 2019/5/1 8:47 AM
 * @Version 1.0
 **/
public class BaseCriteria {

    @ApiModelProperty(value = "当前页码，从1开始，默认为1", example = "1")
    private Integer currPage = 1;
    @ApiModelProperty(value = "每页显示条数，默认为20", example = "20")
    private Integer pageSize = 20;

    public void check() {
        if (this.currPage <= 0) {
            throw new IllegalArgumentException("currPage must large than 0");
        }
        if (this.pageSize <= 0 || this.pageSize > 100) {
            throw new IllegalArgumentException("pageSize must large than 0 and less than 101");
        }
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BaseCriteria{" +
                "currPage=" + currPage +
                ", pageSize=" + pageSize +
                '}';
    }
}