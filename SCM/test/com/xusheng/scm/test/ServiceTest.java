package com.xusheng.scm.test;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xusheng.scm.entity.Account;
import com.xusheng.scm.entity.Goods;
import com.xusheng.scm.entity.Page;
import com.xusheng.scm.entity.Supplier;
import com.xusheng.scm.service.AccountService;
import com.xusheng.scm.service.GoodsService;
import com.xusheng.scm.service.SupplierService;
import com.xusheng.scm.util.Result;

public class ServiceTest {

	private ApplicationContext ac;
	private SupplierService ss;
	private GoodsService gs;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ss = ac.getBean("supplierServiceImpl",SupplierService.class);
		gs = ac.getBean("goodsServiceImpl",GoodsService.class);
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
	
	@Test
	public void testSel() throws Exception{
		SupplierService ss = ac.getBean("supplierServiceImpl",SupplierService.class);
		Page<Supplier> page = new Page<Supplier>();
		
		System.out.println(ss.selectPage(page));
	}
	
	@Test
	public void testDelByID() throws Exception{
		String[] str = {"9","10"};
		System.out.println(ss.deletePageById(str));
	}
	
	@Test
	public void testInsert() throws Exception{
		BigDecimal bd = new BigDecimal(1500);
		Supplier supplier = new Supplier(1112,"3224","3224","3224","3224","3224",bd,"3224");
		System.out.println(ss.insert(supplier));
	}
	
	@Test
	public void testUpdate() throws Exception{
		BigDecimal bd = new BigDecimal(1500);
		Supplier supplier = new Supplier(1112,"xs","3224","3224","3224","3224",bd,"3224");
		System.out.println(ss.update(supplier));
	}
	
	@Test
	public void testSel1() throws Exception{
		Goods goods = new Goods();
		goods.setGoodsName("%note4%");
		Page<Goods> page = new Page<Goods>();
		page.setParamEntity(goods);
		page.setPage(1);
		page.setRows(2);
		System.out.println(gs.selectPage(page));
	}
}
