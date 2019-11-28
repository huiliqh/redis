package com.errordataredis.redisviews.handler;


import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class InterceptorMy implements HandlerInterceptor {
    private long time =0;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("接收到请求.."+request.getHeaderNames());
        long timeMillis= System.currentTimeMillis();
        if (time==0){
            time = timeMillis;
        }
        System.out.println("正在验证该请求是否合法....");
       int t = (int) (timeMillis- time)/1000;
        System.out.println("请求时间间隔"+t);
        if (t<3){
            time = timeMillis;
            if (t==0){
                System.out.println(request.getHeaderNames()+"请求通过---->>>");
                return true;
            }else {
                System.out.println(request.getHeaderNames()+"请求不合法已拦截....<-");
                return false;
            }
        }
        time = timeMillis;
        System.out.println(request.getHeaderNames()+"请求通过---->>>");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
