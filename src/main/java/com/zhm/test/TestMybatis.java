package com.zhm.test;

import com.zhm.dao.AccountDao;
import com.zhm.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lzmtx
 * @date 2019/4/12 - 9:19
 */
public class TestMybatis {
    @Test
    public void run1() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        //关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run2() throws Exception {
        Account account = new Account();
        account.setId(4);
        account.setName("熊二");
        account.setMoney(3200.0);
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);

        //保存
        dao.saveAccount(account);
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }
}
