package com.carRent4_0.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: carRent4_0
 * @description:
 * @author: Mr.Like
 * @create: 2021-10-27 10:40
 **/
@Configuration
public class MyMvcconfig implements WebMvcConfigurer {
    //自定义视图解析器

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");//输入这两个 url时会跳转到 templates 下的 index
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/change.html").setViewName("change");
        registry.addViewController("/admin/truckAdd.html").setViewName("truckAdd");
        registry.addViewController("/admin/busAdd.html").setViewName("busAdd");
        registry.addViewController("/admin/carAdd.html").setViewName("carAdd");
        registry.addViewController("/admin.html").setViewName("admin");
    }




    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor())
                .addPathPatterns("/user/**","/admin/**","/admin.html")
                .excludePathPatterns("/index.html","/","/css/*","/js/**","/img/**");
    }


}

