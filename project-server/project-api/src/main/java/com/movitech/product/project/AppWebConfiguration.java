package com.movitech.product.project;

import com.movitech.generics.module.security.auth.client.interceptor.UserAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 启动配置类
 *
 * @author jim
 * @version 2018-11-10
 */
@Configuration("McWebConfiguration")
@Primary
public class AppWebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getUserAuthRestInterceptor()).addPathPatterns("/**");
    }


    @Bean
    UserAuthInterceptor getUserAuthRestInterceptor() {
        return new UserAuthInterceptor(false);
    }

    /**
     * 需要用户和服务认证判断的路径
     * @return
     */
   /* private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                //"/user/**",
                //"/resource/**",
                //"/permissions/**"
        };
        Collections.addAll(list, urls);
        return list;
    }*/

}
