package com.caijunjie.Bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@ConfigurationProperties("person")
@Component
@Data
@Profile(value = {"prod","default"})
public class Boss implements Person{
    private String name;
    private String age;

}
