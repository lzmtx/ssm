package com.zhm.service;

import com.zhm.domain.Account;

import java.util.List;

/**
 * @author lzmtx
 * @date 2019/4/11 - 12:09
 */
public interface AccountService {
    //查询所有账户
    public List<Account> findAll();

    //保存账户信息
    public void saveAccount(Account account);
}
