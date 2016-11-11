package com.xusheng.scm.dao;

import java.util.List;
import com.xusheng.scm.entity.Account;


public interface AccountDao {

	public List<Account> selAllAcc();
	
	public int addAcc(Account acc);
}
