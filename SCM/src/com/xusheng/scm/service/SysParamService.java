package com.xusheng.scm.service;

import java.util.Map;

import com.xusheng.scm.entity.SysParam;

public interface SysParamService extends BaseService<SysParam> {

	public Map<String,Object> selectSysParam(String type) throws Exception;
}
