package com.zhangwenit.zhanglei.demo.api.constant;

/**
 * @Description 状态值集
 * @Author ZWen
 * @Date 2019/4/28 6:10 PM
 * @Version 1.0
 **/
public interface StateConstant {

    ////*********************登录用户状态**********************
    /**
     * 冻结
     */
    int USER_STATE_FREEZE = 2;
    /**
     * 正常
     */
    int USER_STATE_ACTIVE = 1;


    ////*********************登录用户类型**********************
    /**
     * 管理员账户
     */
    int USER_TYPE_MANAGER = 1;
    /**
     * 普通账户
     */
    int USER_TYPE_ORDINARY = 2;

    ////*********************饭店状态**********************
    /**
     * 删除
     */
    int RESTAURANT_STATE_FREEZE = 2;
    /**
     * 正常
     */
    int RESTAURANT_STATE_ACTIVE = 1;

    ////*********************小程序用户状态**********************
    /**
     * 删除
     */
    int THIRD_USER_STATE_FREEZE = 2;
    /**
     * 正常
     */
    int THIRD_USER_STATE_ACTIVE = 1;
}
