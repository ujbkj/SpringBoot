package com.catering.system.api.feign;

import com.catering.common.core.constant.ServiceNameConstants;
import com.catering.common.core.domain.R;
import com.catering.common.core.web.domain.AjaxResult;
import com.catering.system.api.domain.SysEateryCoupons;
import com.catering.system.api.domain.SysUserAppletInfo;
import com.catering.system.api.feign.factory.RemoteUserFallbackFactory;
import com.catering.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务
 *
 * @author catering
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService
{
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 结果
     */
    @GetMapping(value = "/user/info/{username}")
    public R<LoginUser> getUserInfo(@PathVariable("username") String username);

    @GetMapping(value = "/user/queryPrintType/{eateryUid}")
    public R<Integer> queryPrintType(@PathVariable("eateryUid") String eateryUid);

    @GetMapping(value = "/applet/getAppLetIdInfo/{eateryUid}")
    public R<SysUserAppletInfo> getAppLetIdInfo(@PathVariable("eateryUid") String eateryUid);

    @GetMapping("/user/queryEateryPhone/{eateryUid}")
    public R<String> queryEateryPhone(@PathVariable("eateryUid") String eateryUid);

    @GetMapping("/user/queryEateryInterest/{eateryUid}")
    public R<String> queryEateryInterest(@PathVariable("eateryUid") String eateryUid);

    @GetMapping("/user/queryEateryUid/{phoneNumber}")
    public R<String> selectEateryUid(@PathVariable("phoneNumber") String phoneNumber);

    @GetMapping("/coupons/queryCoupons/{eateryUid}/{couponsUid}")
    public R<SysEateryCoupons> queryCoupons(@PathVariable("eateryUid") String eateryUid , @PathVariable("couponsUid") String couponsUid);
}
