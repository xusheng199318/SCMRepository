package com.xusheng.scm.dao;

import java.util.List;
import java.util.Map;

import com.xusheng.scm.entity.Supplier;

public interface SupplierMapper extends BaseMapper<Supplier>{
	public List<Map<String,String>> selectSupplier(Map<String,String> paramMap);
}