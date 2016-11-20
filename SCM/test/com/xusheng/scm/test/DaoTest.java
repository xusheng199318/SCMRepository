package com.xusheng.scm.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xusheng.scm.dao.AccountDao;
import com.xusheng.scm.dao.SupplierMapper;
import com.xusheng.scm.entity.Account;
import com.xusheng.scm.entity.Page;
import com.xusheng.scm.entity.Supplier;

public class DaoTest {
	ApplicationContext ac;
	ApplicationContext ac1;
	SupplierMapper sm;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ac1 = new ClassPathXmlApplicationContext("spring-mvc.xml");
		sm = ac.getBean("supplierMapper",SupplierMapper.class);
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
	
	@Test
	public void testInse(){
		Supplier s = new Supplier();
		s.setSupName("中兴");
		s.setSupId(6);
		SupplierMapper sd = ac.getBean("supplierMapper",SupplierMapper.class);
		sd.insert(s);
	}
	
	@Test
	public void testPage(){
		Supplier supplier = new Supplier();
		Page<Supplier> page = new Page<Supplier>();
		SupplierMapper sm = ac.getBean("supplierMapper",SupplierMapper.class);
		System.out.println(sm.selectPage(page));
		//System.out.println(sm.selectPageCount(supplier));
	}
	
	@Test
	public void testDeletePageById(){
		String[] pks = {"9","10"};
		System.out.println(sm.deletePageById(pks));
	}
	
	@Test
	public void testInsert(){
		BigDecimal bd = new BigDecimal(1500);
		Supplier supplier = new Supplier(1111,"3224","3224","3224","3224","3224",bd,"3224");
		System.out.println(sm.insert(supplier));
	}
	
	@Test
	public void testUpdate(){
		BigDecimal bd = new BigDecimal(1500);
		Supplier supplier = new Supplier(1111,"xs14324","xs4","xs24","3224","3224",bd,"3224");
//		Supplier supplier = new Supplier();
//		supplier.setSupAddress("423");
//		supplier.setSupId(1111);
//		supplier.setSupLinkman("xs3");
		System.out.println(sm.update(supplier));
	}
}
