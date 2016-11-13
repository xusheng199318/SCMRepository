package com.xusheng.scm.dao;

import com.xusheng.scm.entity.Account;

public interface AccountDao extends BaseMapper<Account>{

	public String login(Account account);
}
