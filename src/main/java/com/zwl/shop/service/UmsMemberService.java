package com.zwl.shop.service;

import com.zwl.shop.common.api.CommonResult;

/**
 * @author zwl
 * @date : 2021/1/22 16:37
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
