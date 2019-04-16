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

    //根据id删除账户
    public void idDel(int id);

    //根据id更改账户
    public void idUpdate(Account account);

    //保存账户信息
    public void saveAccount(Account account);
}
