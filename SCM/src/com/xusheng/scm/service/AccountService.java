package com.xusheng.scm.service;

import java.util.List;

import com.xusheng.scm.entity.Account;

public interface AccountService {

	public List<Account> selAllAcc();
	
	public int addAcc(Account acc);
}
