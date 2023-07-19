package com.cjj.Config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
 */
public class MybatisConfig {
    @Bean
    public MybatisPlusInterceptor paginationInnerInreceptor() {
     MybatisPlusInterceptor mybatisPlusInterceptor=new MybatisPlusInterceptor();
       //这是分页拦截器
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        //设置请求的页面大于最大页后操作 true调回到首页  false  继续请求  默认false
        paginationInnerInterceptor.setOverflow(true);
        //设置最大单页限制数量 默认500条 -1 不受限制
        //开启count的join优化，只针对部分left join
        paginationInnerInterceptor.setMaxLimit(500L);
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }


}
