package com.carRent4_0.config;

/**
 * @program: carRent4_0
 * @description:
 * @author: Mr.Like
 * @create: 2021-11-03 15:43
 **/
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Path/**").addResourceLocations("file:/D:/文档/新鲜出炉的程序/SpringBoot/carRent4_0/src/main/resources/static/img");
        super.addResourceHandlers(registry);
    }
}

