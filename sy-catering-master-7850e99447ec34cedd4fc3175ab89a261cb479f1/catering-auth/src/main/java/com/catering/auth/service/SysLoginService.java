package com.catering.auth.service;

import com.catering.common.core.constant.Constants;
import com.catering.common.core.constant.UserConstants;
import com.catering.common.core.domain.R;
import com.catering.common.core.enums.UserStatus;
import com.catering.common.core.exception.BaseException;
import com.catering.common.core.utils.SecurityUtils;
import com.catering.common.core.utils.StringUtils;
import com.catering.system.api.feign.RemoteLogService;
import com.catering.system.api.feign.RemoteUserService;
import com.catering.system.api.domain.SysUser;
import com.catering.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登录校验方法
 *
 * @author catering
 */
@Component
public class SysLoginService
{
    @Autowired
    private RemoteLogService remoteLogService;

    @Autowired
    private RemoteUserService remoteUserService;

    /**
     * 登录
     */
    public LoginUser login(String username, String password)
    {
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(username, password))
        {
            remoteLogService.saveLogininfor(username, Constants.LOGIN_FAIL, "用户/密码必须填写");
            throw new BaseException("用户/密码必须填写");
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            remoteLogService.saveLogininfor(username, Constants.LOGIN_FAIL, "用户密码不在指定范围");
            throw new BaseException("用户密码不在指定范围");
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            remoteLogService.saveLogininfor(username, Constants.LOGIN_FAIL, "用户名不在指定范围");
            throw new BaseException("用户名不在指定范围");
        }
        // 查询用户信息
        R<LoginUser> userResult = remoteUserService.getUserInfo(username);

        if (R.FAIL == userResult.getCode())
        {
            throw new BaseException(userResult.getMsg());
        }

        if (StringUtils.isNull(userResult) || StringUtils.isNull(userResult.getData()))
        {
            remoteLogService.saveLogininfor(username, Constants.LOGIN_FAIL, "登录用户不存在");
            throw new BaseException("登录用户：" + username + " 不存在");
        }
        LoginUser userInfo = userResult.getData();
        SysUser user = userResult.getData().getSysUser();
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag()))
        {
            remoteLogService.saveLogininfor(username, Constants.LOGIN_FAIL, "对不起，您的账号已被删除");

            throw new BaseException("对不起，您的账号：" + username + " 已被删除");
        }
        if (UserStatus.DISABLE.getCode().equals(user.getStatus()))
        {
            remoteLogService.saveLogininfor(username, Constants.LOGIN_FAIL, "用户已停用，请联系管理员");
            throw new BaseException("对不起，您的账号：" + username + " 已停用");
        }
        if (!SecurityUtils.matchesPassword(password, user.getPassword()))
        {
            remoteLogService.saveLogininfor(username, Constants.LOGIN_FAIL, "用户密码错误");
            throw new BaseException("用户不存在/密码错误");
        }
        remoteLogService.saveLogininfor(username, Constants.LOGIN_SUCCESS, "登录成功");
        return userInfo;
    }

    public void logout(String loginName)
    {
        remoteLogService.saveLogininfor(loginName, Constants.LOGOUT, "退出成功");
    }
}
