package com.xusheng.scm.service;

import com.xusheng.scm.entity.BuyOrder;
import com.xusheng.scm.util.Result;

public interface BuyOrderService extends BaseService<BuyOrder>{

	public Result insertByOrder(BuyOrder buyOrder) throws Exception;
}
