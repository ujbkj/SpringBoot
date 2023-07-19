package com.caijunjie.springboot_web.config;
import com.caijunjie.springboot_web.convert.CaijunjieMessageConvert;
import com.caijunjie.springboot_web.pojo.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
         HiddenHttpMethodFilter methodfliter = new HiddenHttpMethodFilter();
         methodfliter.setMethodParam("_m");
        return  methodfliter;
    }

    @Bean
    public  WebMvcConfigurer webMvcConfigurer(){

        return new WebMvcConfigurer() {

            //自定义内容协商策略配置(format)
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypeMap=new HashMap<>();
                mediaTypeMap.put("json",MediaType.APPLICATION_JSON);
                mediaTypeMap.put("xml",MediaType.APPLICATION_XML);
                mediaTypeMap.put("cjj",MediaType.parseMediaType("application/caijunjie"));
                //指定支持解析哪里参数对应的哪些媒体类型
                //基于参数的
                ParameterContentNegotiationStrategy strategy = new ParameterContentNegotiationStrategy(mediaTypeMap);
                //改变formap名字
                //strategy.setParameterName("jj");
                //基于请求头的
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();

                configurer.strategies(Arrays.asList(strategy,headerContentNegotiationStrategy));
            }

            //配置扩展自定义MessageConverter
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new CaijunjieMessageConvert());
            }
            //    第二种写法
            //配置矩阵变量
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper=new UrlPathHelper();
                 // 移除分号后面的内容，矩阵变量就可以生效
                 urlPathHelper.setRemoveSemicolonContent(false);
                 configurer.setUrlPathHelper(urlPathHelper);
            }
            //配置自定义Convert
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        //前面名字，后面年龄
                        if(!StringUtils.isEmpty(source)){
                            Pet pet=new Pet();
                            String[] split=source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }

                });
            }
        };
    }

//    第一种写法，实现WebMvcConfigurer接口
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper=new UrlPathHelper();
//        //移除分号后面的内容，矩阵变量就可以生效
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }

}
