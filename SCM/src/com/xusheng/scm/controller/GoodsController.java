package com.xusheng.scm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xusheng.scm.entity.Goods;
import com.xusheng.scm.entity.Page;
import com.xusheng.scm.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/selectGoods.do")
	@ResponseBody
	public Map<String, Object> selectGoodsPage(Page<Goods> page,Goods goods){
		page.setParamEntity(goods);
		Map<String, Object> map = null;
		try {
			page = goodsService.selectPage(page);
			map = page.getMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
