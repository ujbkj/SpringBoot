package com.catering.gateway.service;

import com.catering.common.core.exception.CaptchaException;
import com.catering.common.core.web.domain.AjaxResult;

import java.io.IOException;

/**
 * 验证码处理
 *
 * @author catering
 */
public interface ValidateCodeService
{
    /**
     * 生成验证码
     */
    public AjaxResult createCapcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCapcha(String key, String value) throws CaptchaException;
}
