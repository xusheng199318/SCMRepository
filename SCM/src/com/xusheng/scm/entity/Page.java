package com.xusheng.scm.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> implements Serializable{

	private static final long serialVersionUID = -1908141888475967303L;

	private Integer page;
	
	private Integer rows;
	
	private Integer totalRecord;
	
	private List<T> list;
	
	private String keyWord;
	
	private T paramEntity;
	
	private Integer start;
	
	private Map<String,Object> map;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	
	
	public T getParamEntity() {
		return paramEntity;
	}

	public void setParamEntity(T paramEntity) {
		this.paramEntity = paramEntity;
	}

	public Integer getStart() {
		start = (page-1)*rows;
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}


	public Map<String, Object> getMap() {
		map = new HashMap<String,Object>();
		map.put("total", totalRecord);
		map.put("rows", list);
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Page(Integer page, Integer rows, Integer totalRecord, List<T> list,
			String keyWord, Integer start) {
		this.page = page;
		this.rows = rows;
		this.totalRecord = totalRecord;
		this.list = list;
		this.keyWord = keyWord;
		this.start = start;
	}

	public Page() {}

	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + ", totalRecord="
				+ totalRecord + ", list=" + list + ", keyWord=" + keyWord
				+ ", paramEntity=" + paramEntity + ", start=" + start + "]";
	}

	

	
	
}
