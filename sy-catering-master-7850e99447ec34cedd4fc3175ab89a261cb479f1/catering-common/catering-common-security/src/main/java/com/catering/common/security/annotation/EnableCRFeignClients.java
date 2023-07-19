package com.catering.common.security.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;

/**
 * 自定义feign注解
 * 添加basePackages路径
 *
 * @author catering
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableCRFeignClients
{
    String[] value() default {};

    String[] basePackages() default { "com.catering" };

    Class<?>[] basePackageClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    Class<?>[] clients() default {};
}
