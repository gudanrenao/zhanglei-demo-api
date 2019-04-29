package com.zhangwenit.zhanglei.demo.api.enums;

import java.util.HashSet;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/28 5:58 PM
 * @Version 1.0
 **/
@SuppressWarnings("all")
public enum CommonExceptionEnum {

    PERMISSION_DENIED(10001,"账户无权限(需要使用管理员账户)"),
    MANAGE_USER_EDIT_ERROR(10002,"管理员账户状态不可修改"),
    USER_FREEZE(10003,"账户被冻结，无法登陆"),
    NAMNE_OR_PWD_ERROR(10004,"登录名或密码错误"),
    LOGIN_CODE_NULL_ERROR(10005,"code不能为空"),

    SUCCESS(0, "SUCCESS"),
    DATABASE_OPERATION_EXCEPTION(1001, "数据库操作失败"),
    PARAMETER_EXCEPTION(1002, "参数错误: %s"),
    SYSTEM_INTERNAL_EXCEPTION(1003, "系统内部错误"),
    INVALID_TOKEN(1004, "无效的token"),
    HTTP_EXCEPTION(1005, "http异常"),
    GET_TOKEN_FAIL(1006, "获取token失败"),
    GET_PARAM_FAIL(1007, "获取参数失败"),
    UNKOWN_EXCEPTION(1008, "未知异常"),
    OPERATIOIN_FAIL(1009, "操作失败"),
    FEIGN_RESPONSE_FAIL(1010, "%s系统获取不到数据"),
    ROLE_PATTERN_EXCEPTION(1011, "%s规则文件格式不正确, 实际为%s, 应为%s"),
    COMPOENT_STATUS_ERROR(1012, "%s状态不正常, 状态为: %s"),
    PARAMETERS_IS_NULL(5003, "参数不能为空"),
    FAIL(5, "FAIL"),
    QA_SEARCH_DATA_NOT(500, "数据为空"),
    REDIS_EXCEPTION(540, "redis异常"),
    DATABASE_EXCEPTION(522, "数据库异常"),
    DATA_EXCEPTION(5000, "数据异常: %s"),
    JSON_OBJECT_PARSE_FAIL(523, "JSON解析失败"),
    DOCTOR_IS_NOT_EXIST(5000, "医生不存在"),
    QA_ORDER_IS_NOT_EXIST(5000, "提问订单不存在"),
    QA_IS_NOT_EXIST(5000, "问题不存在"),
    QA_PAYMENT_IS_EXIST(5000, "已支付"),
    QA_PAYMENTINFO_IS_NOT_EXIST(5000, "支付信息不存在"),
    QA_COUPON_IS_DISABLE(5000, "当前优惠券不可用，请重新选择！"),
    QA_ANSWER_IS_NOT_PAY(5000, "购买后才能听哦！"),
    CODE_ERROE(5000, "请输入正确的验证码"),
    CODE_NULL(5000, "请输入正确的验证码"),
    CODE_FAILURE(5000, "请输入正确的验证码"),
    PHOHE_NULL(5000, "请输入正确的手机号"),
    PHONE_ACCOUNT_CHECK_FAIL(5000, "手机号或账号未注册或不匹配"),
    ACCOUNT_CHECK_FAIL(5000, "账号不存在或存在多个"),
    PHOHE__CODE_ERROE(5000, "请输入正确的手机号"),
    ALREADY_BIND(5000, "您已经绑定其余微信，不能继续绑定！"),
    CODE_ERROE_MORE(5000, "错误次数超过六次"),
    SMS_FAIL_PWD(5000, "短信发送初始化密码失败"),
    SMS_CONPONS_FAIL(5000, "优惠券短信发送失败"),
    SMS_CONPONS_SUCCESS(5000, "优惠券短信发送成功"),
    SMS_FAIL_NULL(5000, "发送短信的为空"),
    SMS_FAIL(5000, "短信发送失败"),
    TOKEN_EXPIXE(5010, "TOKRN无效"),
    SMS_MORE(5000, "请求频繁"),
    GET_FAIL_OPENID(5000, "获取openid失败"),
    REGIT_FAIL(5000, "注册失败"),
    OPENID_FAIL(5000, "该微信已和其他手机号绑定"),
    USER_BINGDING(5000, "该手机号已绑定过微信，请更换手机号"),
    WECHAT_BINGDING(5000, "该微信已和其他手机号绑定"),
    USER_NOT_REGIT(5000, "用户未注册"),
    JKK_OVER_DATE(5000, "该健康卡已过期，请重新选择！"),
    WEIXIN_FAIL(5000, "调用微信接口失败"),
    PASSWORD_CONFIRM(5000, "两次输入的密码不一致"),
    PASSWORD_LENGTH_ERROR(5000, "密码长度有误(6~20位)"),
    PASSWORD_ERROR(5000, "密码错误");

    public final int value;
    public final String desc;
    private static HashSet<Integer> hashSet = new HashSet();

    private CommonExceptionEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    public static boolean isDefined(int value) {
        return hashSet.contains(value);
    }

    static {
        hashSet.clear();
        CommonExceptionEnum[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            CommonExceptionEnum returnStatus = var0[var2];
            hashSet.add(returnStatus.getValue());
        }

    }
}
