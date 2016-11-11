package com.xusheng.scm.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusheng.scm.entity.Account;
import com.xusheng.scm.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Resource
	private AccountService accountService;
	
	@RequestMapping("/select.do")
	public String selAcc(){
		System.out.println("进入acccontroller");
		System.out.println(accountService.selAllAcc());;
		return "forward:/jsp/main.jsp";
	}
	
	@RequestMapping("/insert.do")
	public String addAcc(Account acc){
		accountService.addAcc(acc);
		return "forward:/jsp/main.jsp";
	}
}
