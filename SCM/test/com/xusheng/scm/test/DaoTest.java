package com.xusheng.scm.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xusheng.scm.dao.AccountDao;
import com.xusheng.scm.dao.SupplierMapper;
import com.xusheng.scm.entity.Account;
import com.xusheng.scm.entity.Supplier;

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
	public void testLogin(){
		Account account = new Account();
		account.setAccLogin("admin");
		AccountDao ad = ac.getBean("accountDao",AccountDao.class);
		String pwd = ad.login(account);
		System.out.println(pwd);
	}
	
	
}
