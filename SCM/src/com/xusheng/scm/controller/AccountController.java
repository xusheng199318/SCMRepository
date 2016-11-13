package com.xusheng.scm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusheng.scm.entity.Account;
import com.xusheng.scm.service.AccountService;
import com.xusheng.scm.util.Result;

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
	
	@RequestMapping("/login.do")
	public String login(Account account,HttpServletRequest req,HttpSession session){
		Result result = accountService.login(account);
		if(result.getStatus() == 1){
			session.setAttribute("account", account);
			return "forward:/WEB-INF/jsp/main.jsp";
		}else{
			req.setAttribute("msg", result.getMsg());
		}
		return "forward:/login.jsp";
	}
}
