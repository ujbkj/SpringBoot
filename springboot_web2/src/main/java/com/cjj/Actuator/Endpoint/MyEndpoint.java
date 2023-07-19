package com.cjj.Actuator.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component

@Endpoint(id = "myEndpoint")
/**
 * 开启需要绑定配置文件，使用cmd的jconsole也能调用
 * @ConfigurationProperties(prefix = "")
 */
//@ConfigurationProperties(prefix = "docker")
public class MyEndpoint {

    @ReadOperation
    public Map getdockerstarted(){
        return Collections.singletonMap("info","getdockerInfo->started......");
    }

    @WriteOperation
    public Map getdockerstop(){
        return Collections.singletonMap("stop","stopdocker->stop.....");
    }


}
