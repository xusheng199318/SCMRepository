package com.xusheng.scm.service;

import com.xusheng.scm.entity.Account;
import com.xusheng.scm.util.Result;

public interface AccountService extends BaseService<Account> {

	public Result login(Account account);
}
