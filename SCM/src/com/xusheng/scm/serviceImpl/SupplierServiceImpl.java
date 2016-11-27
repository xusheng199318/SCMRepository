package com.xusheng.scm.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xusheng.scm.dao.SupplierMapper;
import com.xusheng.scm.entity.Page;
import com.xusheng.scm.entity.Supplier;
import com.xusheng.scm.service.SupplierService;
import com.xusheng.scm.util.Result;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierMapper supplierMapper;

	@Override
	public Result insert(Supplier entity) {
		Result result = new Result();
		if(supplierMapper.insert(entity)>0){
			result.setStatus(0);
			result.setMsg("添加成功");
			System.out.println(result);
		}else{
			result.setStatus(1);
			result.setMsg("添加失败");
			System.out.println(result);
		}
		return result;
	}

	@Override
	public int delete(Supplier entity) {
		return 0;
	}

	@Override
	public Result update(Supplier entity) {
		Result result = new Result();
		if(supplierMapper.update(entity)>0){
			result.setStatus(0);
			result.setMsg("修改成功");
		}
		else{
			result.setStatus(1);
			result.setMsg("修改失败");
		}
		return result;
	}

	@Override
	public Supplier select(Supplier entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Supplier> selectPage(Page<Supplier> page) throws Exception {
		page.setTotalRecord(supplierMapper.selectPageCount(page));
		page.setList(supplierMapper.selectPage(page));
		return page;
	}

	/**
	 * 根据id删除记录
	 */
	public Result deletePageById(String[] pks) throws Exception {
		Result result = new Result();
		Integer delRows = supplierMapper.deletePageById(pks);
		if(delRows>0){
			result.setStatus(1);
			result.setMsg("删除成功");
		}else{
			result.setStatus(0);
			result.setMsg("删除失败");
		}
		return result;
	}
	
	
}
