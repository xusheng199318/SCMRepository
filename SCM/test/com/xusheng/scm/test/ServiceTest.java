package com.xusheng.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xusheng.scm.entity.Account;
import com.xusheng.scm.service.AccountService;
import com.xusheng.scm.util.Result;

public class ServiceTest {

	private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testLogin(){
		AccountService as = ac.getBean("accountService",AccountService.class);
		Account account = new Account();
		account.setAccLogin("admin4");
		account.setAccPass("admin1");
		Result result = as.login(account);
		System.out.println(result);
	}
}
