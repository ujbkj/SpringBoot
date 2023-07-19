package com.catering.system.api.feign;

import com.catering.common.core.constant.ServiceNameConstants;
import com.catering.common.core.domain.R;
import com.catering.system.api.feign.factory.RemoteAddMemberFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(contextId = "remoteAddMemberService", value = ServiceNameConstants.MEMBERPAY_SERVICE, fallbackFactory = RemoteAddMemberFallbackFactory.class)
public interface RemoteAddMemberService {

    @PostMapping("/wxpy/profitSharingAddReceiverPayOrder")
    public R<Map<String, String>> profitSharingAddReceiverPayOrder(@RequestBody Map<String, String> map);
}
