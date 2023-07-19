package com.catering.quartz.task;

import com.catering.common.core.constant.MemberConstants;
import com.catering.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 * @author ruoyi
 */
@Component("cateringTask")
public class CateringTask
{
    @Autowired
    private RedisService redisService;

    public void initCalculator() {
        redisService.delCacheMapValue(MemberConstants.CATERING_CALCULATOR_NAME, null);
        System.out.println("初始化列表redis=======");
    }
}
