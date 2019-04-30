package com.zhangwenit.zhanglei.demo.api.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhangwenit.zhanglei.demo.api.constant.StateConstant;
import com.zhangwenit.zhanglei.demo.api.dto.MiniLoginUser;
import com.zhangwenit.zhanglei.demo.api.dto.ThirdUserDto;
import com.zhangwenit.zhanglei.demo.api.dto.wechat.CodeToSessionResponse;
import com.zhangwenit.zhanglei.demo.api.enums.CommonExceptionEnum;
import com.zhangwenit.zhanglei.demo.api.exception.CommonException;
import com.zhangwenit.zhanglei.demo.api.model.ThirdUser;
import com.zhangwenit.zhanglei.demo.api.repository.ThirdUserRepository;
import com.zhangwenit.zhanglei.demo.api.util.CryptoUtil;
import com.zhangwenit.zhanglei.demo.api.util.WeChatRestApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Base64;
import java.util.Date;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/4/29 7:32 PM
 * @Version 1.0
 **/
@Service
public class ThirdUserService {

    @Value("${mini.appId}")
    private String appId;
    @Value("${mini.secret}")
    private String secret;

    private final ThirdUserRepository thirdUserRepository;
    private final RedisService redisService;
    private final WeChatRestApi weChatRestApi;

    public ThirdUserService(ThirdUserRepository thirdUserRepository, RedisService redisService, WeChatRestApi weChatRestApi) {
        this.thirdUserRepository = thirdUserRepository;
        this.redisService = redisService;
        this.weChatRestApi = weChatRestApi;
    }

    /**
     * 小程序登录
     *
     * @param wxUser 用户允许授权后获取的信息
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public ThirdUserDto login(MiniLoginUser wxUser) throws Exception {
        Assert.notNull(wxUser.getCode(), CommonExceptionEnum.LOGIN_CODE_NULL_ERROR.desc);
        CodeToSessionResponse response = weChatRestApi.miniCodeToSession(wxUser.getCode());
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] value = decoder.decode(wxUser.getEncryptedData());
        byte[] key = decoder.decode(response.getSessionKey());
        byte[] iv = decoder.decode(wxUser.getIv());
        String wxInfo = CryptoUtil.decrypt(value, key, iv, "utf-8");
        if (StringUtils.isNotEmpty(wxInfo)) {
            JSONObject jsonObject = JSON.parseObject(wxInfo);
            String nickName = jsonObject.getString("nickName");
            String province = jsonObject.getString("province");
            String city = jsonObject.getString("city");
            //查询该微信openId是否已注册
            ThirdUser thirdUser = thirdUserRepository.findByOpenId(response.getOpenId());
            if (null == thirdUser) {
                thirdUser = new ThirdUser();
                thirdUser.setStatus(StateConstant.THIRD_USER_STATUS_ACTIVE);
                thirdUser.setOpenId(response.getOpenId());
                thirdUser.setCreateTime(new Date());
                thirdUser.setNickName(nickName);
                thirdUser.setProvinceName(province);
                thirdUser.setCityName(city);
            }
            thirdUser.setLastLoginTime(new Date());
            thirdUser.setUpdateTime(new Date());
            thirdUser = thirdUserRepository.save(thirdUser);
            //创建token
            String token = redisService.setMiniLoginInfo(thirdUser);
            return new ThirdUserDto(token, thirdUser);
        } else {
            throw new CommonException("userInfo is null");
        }
    }
}