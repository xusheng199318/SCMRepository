package com.xusheng.scm.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xusheng.scm.dao.AccountRecordsMapper;
import com.xusheng.scm.dao.BuyOrderDetailMapper;
import com.xusheng.scm.dao.BuyOrderMapper;
import com.xusheng.scm.entity.AccountRecords;
import com.xusheng.scm.entity.BuyOrder;
import com.xusheng.scm.entity.BuyOrderDetail;
import com.xusheng.scm.entity.Page;
import com.xusheng.scm.service.BuyOrderService;
import com.xusheng.scm.util.Result;

@Service("buyOrderService")
public class BuyOrderServiceImpl implements BuyOrderService {
	
	@Autowired
	private BuyOrderMapper buyOrderMapper;
	
	@Autowired
	private BuyOrderDetailMapper buyOrderDetaileMapper;
	
	@Autowired
	private AccountRecordsMapper accountRecordsMapper;

	
	
	@Override
	public Result insert(BuyOrder entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(BuyOrder entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result update(BuyOrder entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuyOrder select(BuyOrder entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BuyOrder> selectPage(Page<BuyOrder> page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result deletePageById(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result insertByOrder(BuyOrder buyOrder) throws Exception {
		Result result = new Result();
		int i = 0;
		String boId = "bo"+UUID.randomUUID().toString().replace("-","");
		buyOrder.setBoId(boId);
		i = buyOrderMapper.insert(buyOrder);
		
		for(BuyOrderDetail bod : buyOrder.getBuyOrderDetails()){
			bod.setBodId(UUID.randomUUID().toString().replace("-",""));
			bod.setBoId(boId);
		}
		buyOrderDetaileMapper.insertList(buyOrder.getBuyOrderDetails());
		
		AccountRecords accountRecords = new AccountRecords();
		// 生成并设置怅务记录的主键
		accountRecords.setArId(String.valueOf("ar"+UUID.randomUUID().toString().replace("-", "")));
		accountRecords.setArAttn(buyOrder.getBoAttn());
		accountRecords.setArArrears(buyOrder.getBoArrears());
		//bo表示商品采购，可以在参数表中加入相关内容
		accountRecords.setArBusType("bo");
		accountRecords.setArDate(buyOrder.getBoDate());
		//优惠金额：用应付金额减去实付金额再减去欠款
		accountRecords.setArDiscount(buyOrder.getBoPayable().subtract(buyOrder.getBoPaid()).subtract(buyOrder.getBoArrears()));
		accountRecords.setArOperator(buyOrder.getBoOperator());
		//采购单号
		accountRecords.setArOrderId(buyOrder.getBoId());
		accountRecords.setArPaid(buyOrder.getBoPaid());
		accountRecords.setArPayable(buyOrder.getBoPayable());
		accountRecords.setArRemark(buyOrder.getBoRemark());
		accountRecords.setSupId(buyOrder.getSupId());
		accountRecordsMapper.insert(accountRecords);
		
		if(i>0){
			result.setStatus(0);
			result.setMsg("插入成功");
		}else{
			result.setStatus(1);
			result.setMsg("插入失败");
		}
		
		return result;
	}

}
