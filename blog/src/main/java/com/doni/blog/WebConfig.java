package com.doni.blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BlogInterceptor())
                .addPathPatterns("/**")//적용할 url
                .excludePathPatterns("/login","/signup","/blog","/error","/imageupload","/view","/board")
                .excludePathPatterns("/css/**","/js/**","/img/**","/*.icon","/*.ico","/");//제외할 url /login/** == /login/하위url모두 제외
    }
}
