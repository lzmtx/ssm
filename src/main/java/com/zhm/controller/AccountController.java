package com.zhm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhm.domain.Account;
import com.zhm.service.AccountService;
import com.zhm.test.TestMybatis;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author lzmtx
 * @date 2019/4/11 - 12:11
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有账户");
        model.addAttribute("users", accountService.findAll());
        return "test";
    }

    @RequestMapping(path = "/findAlla", method = RequestMethod.POST)
    public @ResponseBody List<Account> findAlla(HttpServletResponse response, HttpServletRequest request) throws IOException {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
        return accounts;
    }

    @RequestMapping("/insert")
    public @ResponseBody
    Account insert(@RequestBody Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insert被执行了，接收的数据为" + account);
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return account;
    }

    //表单不能使用@RequestBody Account account方式接收参数
    @RequestMapping("/save")
    public void save(String name, Double money, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("save(): request: name=" + name + ", money=" + money);
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
    }

    @RequestMapping("/testAjax")
    public @ResponseBody Account testAjax(@RequestBody Account account) {
        System.out.println("textAjax(): request: id=" + account.getId() + ", name=" + account.getName() + ", money=" + account.getMoney());
        accountService.saveAccount(account);
        return account;
    }

    @RequestMapping(path = "/idDel", method = RequestMethod.POST)
    public void idDel(int id, HttpServletResponse response) throws IOException{
        System.out.println("idDel(): request: id=" + id);
        accountService.idDel(id);
        //返回json格式的操作状态
        JSONObject obj = new JSONObject();
        obj.put("state", "ok");
        response.getWriter().write(JSON.toJSONString(obj));
    }

    @RequestMapping("/idUpdate")
    public void idUpdate(@RequestBody Account account, HttpServletResponse response) throws IOException {
        System.out.println("idUpdate(): request: id=" + account.getId() + ", name=" +account.getName() + ", money=" +account.getMoney());
        accountService.idUpdate(account);
        //返回json格式的操作状态
        JSONObject obj = new JSONObject();
        obj.put("state", "ok");
        response.getWriter().write(JSON.toJSONString(obj));
    }

    //测试自定义拦截器
    @RequestMapping("/toMain")
    public String tomain() {
        System.out.println("接收请求跳转到main.jsp");
        return "main";
    }

    //测试文件上传
    @RequestMapping("/toUploadFile")
    public String upLoadFile() {
        System.out.println("接收请求跳转到fileUpload.jsp");
        return "fileUpload";
    }

}
