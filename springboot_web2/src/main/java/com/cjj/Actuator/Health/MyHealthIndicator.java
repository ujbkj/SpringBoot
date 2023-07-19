package com.cjj.Actuator.Health;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
@Slf4j

public class MyHealthIndicator extends AbstractHealthIndicator {
    /**
     * 真实检查健康方法
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String,Object> map=new HashMap<>();
        try {
            //redis  获取连接进行测试
            if(1==1){
                builder.status(Status.UP);
                map.put("count",1);
                map.put("ms",100);
            }else{
                builder.status(Status.DOWN);
                map.put("err","错误");
            }
        }catch (Exception e){
           e.printStackTrace();
           builder.status(Status.UNKNOWN);
           map.put("unkown","系统异常");
        }

        builder.withDetail("code",200).withDetails(map);
    }
}
