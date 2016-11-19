package com.xusheng.scm.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xusheng.scm.dao.AccountDao;
import com.xusheng.scm.entity.Account;
import com.xusheng.scm.entity.Page;
import com.xusheng.scm.service.AccountService;
import com.xusheng.scm.util.Result;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao ad;

	@Override
	public Result insert(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Account entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Account entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account select(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result login(Account account) {
		Result result = new Result();
		String inputPwd = account.getAccPass();
		String pwd = ad.login(account);
		if(pwd != null && pwd.equals(inputPwd)){
			result.setStatus(1);
			result.setMsg("用户名密码正确");
			result.setObj(pwd);
		}else{
			result.setStatus(0);
			result.setMsg("用户名或密码错误");
			result.setObj(pwd);
		}
		return result;
	}

	@Override
	public Page<Account> selectPage(Page<Account> page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result deletePageById(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}
