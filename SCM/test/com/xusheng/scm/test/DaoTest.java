package com.xusheng.scm.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xusheng.scm.controller.AccountController;
import com.xusheng.scm.dao.AccountDao;
import com.xusheng.scm.entity.Account;

public class DaoTest {
	ApplicationContext ac;
	ApplicationContext ac1;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ac1 = new ClassPathXmlApplicationContext("spring-mvc.xml");
	}
	
	@Test
	public void testConn(){
		System.out.println(ac.getBean("dataSource"));
	}
	
	@Test
	public void testSel(){
		AccountDao ad = ac.getBean("accountDao",AccountDao.class);
		List<Account> list = ad.selAllAcc();
		System.out.println(list);
	}
	
	@Test
	public void testAdd(){
		AccountDao ad = ac.getBean("accountDao",AccountDao.class);
		Account acc = new Account();
		acc.setAccLogin("admin4");
		acc.setAccPass("admin4");
		System.out.println(ad.addAcc(acc));
	}
}
