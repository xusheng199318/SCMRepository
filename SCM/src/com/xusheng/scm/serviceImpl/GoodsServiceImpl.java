package com.xusheng.scm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xusheng.scm.dao.GoodsMapper;
import com.xusheng.scm.entity.Goods;
import com.xusheng.scm.entity.Page;
import com.xusheng.scm.service.GoodsService;
import com.xusheng.scm.util.Result;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public Result insert(Goods entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Goods entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result update(Goods entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods select(Goods entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Goods> selectPage(Page<Goods> page) throws Exception {
		page.setTotalRecord(goodsMapper.selectPageCount(page));
		page.setList(goodsMapper.selectPage(page));
		return page;
	}

	@Override
	public Result deletePageById(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
