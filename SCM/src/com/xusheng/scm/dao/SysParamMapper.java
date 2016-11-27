package com.xusheng.scm.dao;

import java.util.List;

import com.xusheng.scm.entity.SysParam;


public interface SysParamMapper extends BaseMapper<SysParam> {
    public List<SysParam> selectSysParam(String type);
    public List<SysParam> selectOtherSysParam(String sql);
}