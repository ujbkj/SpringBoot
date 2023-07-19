package com.cjj.service;

import com.cjj.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 默认不要放在容器里面
 */
public class HelloService {
    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName){
        return helloProperties.getPrefix()+":"+userName+"》"+helloProperties.getSuffix();

    }
}
