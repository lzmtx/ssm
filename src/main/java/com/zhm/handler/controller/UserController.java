package com.zhm.handler.controller;

import com.zhm.handler.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author lzmtx
 * @date 2019/4/19 - 11:41
 */
@Controller
public class UserController {
    /**
     * 向用户登陆页面跳转
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String tologin() {
        return "login";
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        String username = user.getUsername();
        String password = user.getPassword();
        //匹配数据库
        if (username != null && "xiaoming".equals(username) && password != null && "123456".equals(password)) {
            session.setAttribute("user_session", user);
            //重定向到主页面的跳转方法
            return "redirect:main";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登陆！");
        return "login";
    }
    /**
     * 向用户页面跳转
     */
    @RequestMapping(value = "main")
    public String toMain() {
        return "main";
    }

    /**
     * 退出登陆
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        return "redirect:login";
    }
}
