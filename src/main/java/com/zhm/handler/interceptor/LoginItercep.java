package com.zhm.handler.interceptor;

import com.zhm.handler.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lzmtx
 * @date 2019/4/20 - 15:57
 */
public class LoginItercep implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取请求的url
        String url = httpServletRequest.getRequestURI();
        System.out.println("url=" + url);
        //仅公开login.jsp
        if (url.indexOf("/login") >= 0) {
            System.out.println("登录拦截器");
            return true;
        }
        //获取session
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user_session");
        //判断session中是否由用户数据，有则返回true，继续向下执行
        if (user != null) {
            System.out.println("登录拦截器，条件符合，给予放行");
            return true;
        }
        //不符合条件的给出提示，并转发到登陆界面
        httpServletRequest.setAttribute("msg", "您还没有登陆，请先登录！");
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
