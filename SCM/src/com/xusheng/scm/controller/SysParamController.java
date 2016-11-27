package com.xusheng.scm.controller;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusheng.scm.service.SysParamService;

@Controller
@RequestMapping("/sysParam")
public class SysParamController extends BaseController {

	@Autowired
	private SysParamService sysParamService;
	
	@PostConstruct
	public void initParam(){
		loadSysParam();
	}
	
	
	public void loadSysParam(){
		try {
			Map<String,Object> sysParamMap = sysParamService.selectSysParam("");
			application.setAttribute("sysParamMap", sysParamMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
