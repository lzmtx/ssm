package com.zhm.handler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lzmtx
 * @date 2019/4/19 - 10:51
 */
@Controller
@RequestMapping("/handler")
public class HelloController {
    /**
     * 页面跳转
     */
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello!即将跳转至handlers.jsp");
        return "handlers";
    }
}
