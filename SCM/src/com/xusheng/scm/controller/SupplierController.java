package com.xusheng.scm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xusheng.scm.entity.Page;
import com.xusheng.scm.entity.Supplier;
import com.xusheng.scm.service.SupplierService;
import com.xusheng.scm.util.Result;

@Controller
@RequestMapping("/supplier")
public class SupplierController extends BaseController{
	
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public Result addSupplier(Supplier supplier){
		Result result = null;
		try {
			result = supplierService.insert(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/selectPage.do")
	@ResponseBody
	public Map<String, Object> selectPage(Page<Supplier> page,Supplier supplier,HttpServletRequest req){
		page.setParamEntity(supplier);
		try {
			page = supplierService.selectPage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page.getMap();
	}
	
	@RequestMapping("/deleteSupplier.do")
	@ResponseBody
	public Result deleteSupplier(String[] pks){
		Result result = null;
		try {
			result = supplierService.deletePageById(pks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/updateSupplier.do")
	@ResponseBody
	public Result updateSupplier(Supplier supplier,HttpServletRequest req){
		Result result = null;
		try {
			result = supplierService.update(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}



