package com.xusheng.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xusheng.scm.entity.Account;
import com.xusheng.scm.service.AccountService;
import com.xusheng.scm.serviceImpl.AccountServiceImpl;

public class ServiceTest {

	private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testSel(){
		AccountService as = ac.getBean("accountService",AccountService.class);
		System.out.println(as.selAllAcc());
	}
	
	@Test
	public void testAdd(){
		AccountService as = ac.getBean("accountService",AccountService.class);
		Account acc = new Account();
		acc.setAccLogin("admin4");
		acc.setAccPass("admin4");
		as.addAcc(acc);
	}
}
