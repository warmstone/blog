package com.ballcat.blog.config;

import com.ballcat.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author pengshun
 * @date 2022-04-10 19:17
 * @description
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;

    public AppConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/admin/**") // 拦截后台请求
                .excludePathPatterns("/admin/login"); // 放行登陆接口
    }
}
