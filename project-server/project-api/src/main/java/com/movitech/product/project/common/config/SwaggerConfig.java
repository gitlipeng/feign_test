package com.movitech.product.project.common.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.movitech.generics.framework.context.RequestContextInterceptor;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author tino
 * @version 2018/7/2
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket docket() {
        ParameterBuilder builder = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        pars.add(builder.name("authorization").description("authorization").modelRef(new ModelRef("string")).parameterType("header").required(false).build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("MC").build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.movitech.product.project"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);
    }


    @Bean
    public RequestContextInterceptor requestContextInterceptor(){
        return new RequestContextInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestContextInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/error")
                .excludePathPatterns("/*swagger-**")
                .excludePathPatterns("/*swagger-**/**")
                .excludePathPatterns("/**/api-docs");
    }

    /**
     * 需要用户和服务认证判断的路径,当前设置仅为UserAuthInterceptor(true)时生效
     * @return
     */
    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                //"/userDashboard/**"
        };
        Collections.addAll(list, urls);
        return list;
    }

    /**
     * configurer.setUseSuffixPatternMatch(false)表示系统对外暴露的URL不会识别和匹配URL.* eg: get请求不会匹配到get.do
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

}
