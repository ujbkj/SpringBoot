package com.catering.system.api.feign.factory;

import com.catering.common.core.domain.R;
import com.catering.common.core.web.domain.AjaxResult;
import com.catering.system.api.domain.SysEateryCoupons;
import com.catering.system.api.domain.SysUserAppletInfo;
import com.catering.system.api.feign.RemoteUserService;
import com.catering.system.api.model.LoginUser;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务降级处理
 *
 * @author catering
 */
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public RemoteUserService create(Throwable throwable)
    {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService()
        {
            @Override
            public R<LoginUser> getUserInfo(String username)
            {
                return R.fail("获取用户失败:" + throwable.getMessage());
            }

            @Override
            public R<Integer> queryPrintType(String eateryUid) {
                return R.fail("系统服务调用失败: " + throwable.getMessage());
            }

            @Override
            public R<SysUserAppletInfo> getAppLetIdInfo(String eateryUid) {
                return R.fail("applet系统服务调用失败: " + throwable.getMessage());
            }

            @Override
            public R<String> queryEateryInterest(String eateryUid) {
                return R.fail("系统服务调用失败: " + throwable.getMessage());
            }

            @Override
            @GetMapping("/user/queryEateryPhone/{eateryUid}")
            public R<String> queryEateryPhone(@PathVariable("eateryUid") String eateryUid){
                return R.fail("系统服务调用失败: " + throwable.getMessage());
            }

            @Override
            public R<String> selectEateryUid(String phoneNumber) {
                return R.fail("查询桌位信息失败: " + throwable.getMessage());
            }

            @Override
            public R<SysEateryCoupons> queryCoupons(String eateryUid, String couponsUid) {
                return R.fail("查询优惠卷信息失败: " + throwable.getMessage());
            }
        };

    }


}

