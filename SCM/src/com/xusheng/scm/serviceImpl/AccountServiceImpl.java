package com.xusheng.scm.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xusheng.scm.dao.AccountDao;
import com.xusheng.scm.entity.Account;
import com.xusheng.scm.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao ad;

	@Override
	public int insert(Account entity) {
		// TODO Auto-generated method stub
		return 0;
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

	
}
