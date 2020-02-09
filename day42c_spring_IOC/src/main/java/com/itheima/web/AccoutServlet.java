package com.itheima.web;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.utils.BeanFactory;
import org.junit.Test;


/**
 * @program: ketanxiangmu
 * @ClassName AccoutServlet
 * @description:
 * @author: dyl
 * @create: 2020-01-08 22:52
 **/

public class AccoutServlet {
   @Test
    public void doget(){
       //获得请求参数
       //调用业务
       AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
       accountService.reig();
       //响应

    }
}