package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.AccountService;
import com.itheima.utils.BeanFactory;

/**
 * @program: ssm
 * @ClassName AccountServiceImpl
 * @description:
 * @author: dyl
 * @create: 2020-01-09 19:53
 **/

public class AccountServiceImpl implements AccountService {
    @Override
    public void reig() {
        System.out.println("接口方式处理业务");
        AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
        accountDao.sive();
    }
}