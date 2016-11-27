package com.xusheng.scm.service;

import com.xusheng.scm.entity.Page;
import com.xusheng.scm.util.Result;

public interface BaseService<T> {

	public Result insert(T entity) throws Exception;
	
	public int delete(T entity) throws Exception;
	
	public Result update(T entity) throws Exception;
	
	public T select(T entity) throws Exception;
	
	public Page<T> selectPage(Page<T> page) throws Exception;
	
	public Result deletePageById(String[] pks) throws Exception;
}
