package com.movitech.product.project;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.movitech.generics.module.security.auth.client.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SpringBoot启动类
 *
 * @author hawods
 * @version 2018-06-22
 */
@EnableAuthClient
@SpringBootApplication(scanBasePackages = "com.movitech")
@EnableScheduling
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.movitech")
public class AppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppApplication.class);
    }

    @Bean(name = "projectObjectMapper")
    public ObjectMapper objectMapper() {
        //SerializationFeature.FAIL_ON_EMPTY_BEANS 控制对象转json时，子属性对象可为空
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                //DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES  控制json反序列化时，属性允许为空
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
