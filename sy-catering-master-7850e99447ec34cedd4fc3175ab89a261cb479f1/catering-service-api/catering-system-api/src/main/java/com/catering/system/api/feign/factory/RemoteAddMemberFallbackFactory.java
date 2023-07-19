package com.catering.system.api.feign.factory;

import com.catering.common.core.domain.R;
import com.catering.system.api.feign.RemoteAddMemberService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RemoteAddMemberFallbackFactory implements FallbackFactory<RemoteAddMemberService>{
    private static final Logger log = LoggerFactory.getLogger(RemoteAddMemberFallbackFactory.class);
    @Override
    public RemoteAddMemberService create(Throwable throwable) {
        log.error("会员服务调用失败:{}", throwable.getMessage());
        return new RemoteAddMemberService() {


            @Override
            public R<Map<String, String>> profitSharingAddReceiverPayOrder(Map<String, String> map) {
                return R.fail("会员系统服务调用失败: " + throwable.getMessage());
            }
        };
    }
}
