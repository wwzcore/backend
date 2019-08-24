package com.jxmall.jxmall.common;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.jxmall.jxmall.common.WebMvcConfig.SEESION_KEY;
public class LoginInterceptor implements HandlerInterceptor {
     @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
         Object user = request.getSession().getAttribute(SEESION_KEY);
         if( user==null || user.equals("")){
             response.sendError(405,"客户没有登录，不允许进行此操作！");
             return false;
         }
         return true;
     }
}
