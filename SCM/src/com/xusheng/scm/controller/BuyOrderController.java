package com.xusheng.scm.controller;

import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xusheng.scm.entity.BuyOrder;
import com.xusheng.scm.entity.BuyOrderDetail;
import com.xusheng.scm.service.BuyOrderService;
import com.xusheng.scm.util.Result;

@Controller
@RequestMapping("/buyOrder")
public class BuyOrderController extends BaseController{
	
	@Autowired
	private BuyOrderService buyOrderService;

	@RequestMapping("/insertOrder.do")
	@ResponseBody
	public Result insertBuyOrder(BuyOrder buyOrder,String rows){
//		System.out.println(buyOrder);
//		System.out.println(rows);
		Result result = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			BuyOrderDetail[] bod = mapper.readValue(rows, BuyOrderDetail[].class);
			List<BuyOrderDetail> buyOrderDetail = Arrays.asList(bod);
			buyOrder.setBuyOrderDetails(buyOrderDetail);
			result = buyOrderService.insertByOrder(buyOrder);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
}
