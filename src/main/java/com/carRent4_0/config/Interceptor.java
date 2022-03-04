package com.carRent4_0.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: carRent4_0
 * @description:
 * @author: Mr.Like
 * @create: 2021-11-02 21:23
 **/

public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object loginuser = request.getSession().getAttribute("loginuser");

        if(loginuser==null){
            response.sendRedirect("/chen/index.html");//把这个请求专发到index页面
            return false;//设置拦截
        }else{

            return true;//设置放行
        }

    }


}

