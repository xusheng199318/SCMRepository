package com.xusheng.scm.service;

import java.util.List;
import java.util.Map;

import com.xusheng.scm.entity.Supplier;

public interface SupplierService extends BaseService<Supplier> {

	public List<Map<String,String>> selectSupplier(Map<String,String> paramMap);
}
