package com.xusheng.scm.dao;

import java.util.List;

import com.xusheng.scm.entity.BuyOrderDetail;


public interface BuyOrderDetailMapper extends BaseMapper<BuyOrderDetail>{
	
	public int insertList(List<BuyOrderDetail> buyOrderDetails);
}