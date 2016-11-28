package com.xusheng.scm.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xusheng.scm.dao.AccountDao;
import com.xusheng.scm.dao.GoodsMapper;
import com.xusheng.scm.dao.SupplierMapper;
import com.xusheng.scm.dao.SysParamMapper;
import com.xusheng.scm.entity.Account;
import com.xusheng.scm.entity.Goods;
import com.xusheng.scm.entity.Page;
import com.xusheng.scm.entity.Supplier;

public class DaoTest {
	ApplicationContext ac;
	ApplicationContext ac1;
	SupplierMapper sm;
	GoodsMapper gm;
	SysParamMapper sp;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ac1 = new ClassPathXmlApplicationContext("spring-mvc.xml");
		sm = ac.getBean("supplierMapper",SupplierMapper.class);
		gm = ac.getBean("goodsMapper",GoodsMapper.class);
		sp = ac.getBean("sysParamMapper",SysParamMapper.class);
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
	
	@Test
	public void testSele1(){
		Goods goods = new Goods();
		goods.setGoodsName("%note%");
		Page<Goods> page = new Page<Goods>();
		page.setParamEntity(goods);
		System.out.println(gm.selectPageCount(page));
	}
	
	@Test
	public void testSele2(){
		Goods goods = new Goods();
		goods.setGoodsName("%note4%");
		Page<Goods> page = new Page<Goods>();
		page.setParamEntity(goods);
		page.setPage(1);
		page.setRows(1);
		System.out.println(gm.selectPage(page));
	}
	
	@Test
	public void testSysParamMapper(){
		System.out.println(sp.selectSysParam("supType"));
	}
	
	@Test
	public void testTimeMapper(){
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("start", "2016-11-01");
		paramMap.put("end","2016-11-01");
		System.out.println(sm.selectSupplier(paramMap));
	}
}
