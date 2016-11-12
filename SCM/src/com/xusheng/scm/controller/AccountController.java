package com.xusheng.scm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusheng.scm.entity.Account;
import com.xusheng.scm.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController{

	@Resource
	private AccountService accountService;
	
	@RequestMapping("/insert.do")
	public String addAcc(Account acc){
		try {
			accountService.insert(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/jsp/main.jsp";
	}
}
