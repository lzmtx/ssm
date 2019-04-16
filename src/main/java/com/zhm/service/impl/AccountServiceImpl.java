package com.zhm.service.impl;

import com.zhm.dao.AccountDao;
import com.zhm.domain.Account;
import com.zhm.service.AccountService;
import com.zhm.test.TestMybatis;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lzmtx
 * @date 2019/4/11 - 12:10
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户信息");
        return accountDao.findAll();
    }

    @Override
    public void idDel(int id) {
        System.out.println("业务层：根据id删除账户");
        accountDao.idDel(id);
    }

    @Override
    public void idUpdate(Account account) {
        System.out.println("业务层：根据id更新账户");
        accountDao.idUpdate(account);
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户");
        accountDao.saveAccount(account);
    }
}
