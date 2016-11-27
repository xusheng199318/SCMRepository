package com.xusheng.scm.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/base")
public class BaseController {

	@Autowired
	public ServletContext application;
	
	@RequestMapping("/{file}")
	public String goURL(@PathVariable String file){
		return "forward:/WEB-INF/jsp/"+file+".jsp";
	}
}
