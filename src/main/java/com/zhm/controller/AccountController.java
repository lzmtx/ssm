package com.zhm.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhm.domain.Account;
import com.zhm.service.AccountService;
import com.zhm.test.TestMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/findAlla")
    public @ResponseBody Account findAlla(@RequestBody Account account, HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println(account);
        accountService.findAll();
        System.out.println(account);
        return account;
    }

    @RequestMapping("/insert")
    public @ResponseBody
    Account insert(@RequestBody Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insert被执行了，接收的数据为" + account);
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return account;
    }

    @RequestMapping("/save")
    public void save(int id, String name, Double money, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("save(): request: id=" + id + "name=" + name + "money=" + money);
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
    }

    @RequestMapping("/testAjax")
    public @ResponseBody Account testAjax(@RequestBody Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(account);
//        account.setId(12);
//        account.setName("xiaoming");
//        account.setMoney(768.0);
        accountService.saveAccount(account);
        System.out.println(account);
        return account;
    }
}
