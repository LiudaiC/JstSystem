package com.jst.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/4/11.
 */
@Configuration
public class JstConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JstInterceptor())
                .addPathPatterns("/jst/*")
                .excludePathPatterns("/jst/index", "/jst/index.html", "/jst/logout", "/jst/login");
    }
}
