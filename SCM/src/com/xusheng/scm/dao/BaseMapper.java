package com.xusheng.scm.dao;

import java.util.List;

import com.xusheng.scm.entity.Page;

/**
 * 此接口用于提供一些dao层常用的方法
 * 例如：增，删，改，查，分页
 * @author xusheng
 * @param <T>
 *
 */
public interface BaseMapper<T> {

	public int insert(T entity);
	
	public int delete(T entity);
	
	public int update(T entity);
	
	public T select(T entity);
	
	/**
	 * 此方法通过limit关键字进行分页查询
	 * @param page
	 * @return
	 */
	public List<T> selectPage(Page<T> page);
	
	/**
	 * 此方法用于查询总记录数
	 * @param page
	 * @return
	 */
	public Integer selectPageCount(Page<T> page);
	
	/**
	 * 此方法用于通过主键值批量删除数据
	 * @param pks
	 * @return
	 */
	public Integer deletePageById(String[] pks);
}
