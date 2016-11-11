package com.xusheng.scm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xusheng.scm.dao.AccountDao;
import com.xusheng.scm.entity.Account;
import com.xusheng.scm.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao ad;
	
	public List<Account> selAllAcc() {
		List<Account> list = ad.selAllAcc();
		return list;
	}
	
	public int addAcc(Account acc) {
		int j = ad.addAcc(acc);
		return j;
	}

	
	
}
