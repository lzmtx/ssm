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
        //加载配置文件
//        InputStream in = null;
//        List<Account> accounts = null;
//        try {
//            in = Resources.getResourceAsStream("SqlMapConfig.xml");
//            //创建sqlsessionfactory对象
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//            SqlSession session = factory.openSession();
//            //获取代理对象
//            AccountDao dao = session.getMapper(AccountDao.class);
//            accounts = dao.findAll();
//            for (Account account : accounts) {
//                System.out.println(account);
//            }
//            //关闭资源
//            session.close();
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return accounts;
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户");
//        Account account = new Account();
//        try {
//            //加载配置文件
//            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//            //创建sqlsessionfactory对象
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//            SqlSession session = factory.openSession();
//            //获取代理对象
//            AccountDao dao = session.getMapper(AccountDao.class);
//            //保存
//            dao.saveAccount(account);
//            //提交事务
//            session.commit();
//            //关闭资源
//            session.close();
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("插入成功！");

        accountDao.saveAccount(account);
    }
}
