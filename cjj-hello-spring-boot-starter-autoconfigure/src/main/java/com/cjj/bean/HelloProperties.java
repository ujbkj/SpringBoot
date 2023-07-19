package com.cjj.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cjj.hello")
public class HelloProperties {

    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private String suffix;

}
