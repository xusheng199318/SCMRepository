package com.xusheng.scm.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xusheng.scm.dao.SysParamMapper;
import com.xusheng.scm.entity.Page;
import com.xusheng.scm.entity.SysParam;
import com.xusheng.scm.service.SysParamService;
import com.xusheng.scm.util.Result;

@Service("sysParamService")
public class SysParamServiceImpl implements SysParamService{
	
	@Autowired
	private SysParamMapper sysParamMapper;

	@Override
	public Result insert(SysParam entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(SysParam entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result update(SysParam entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysParam select(SysParam entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SysParam> selectPage(Page<SysParam> page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result deletePageById(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String,Object> selectSysParam(String type) {
		List<SysParam> sysParam = sysParamMapper.selectSysParam(type);
		Map<String,Object> sysParamMap = new HashMap<String,Object>();
		Map<String,String> fieldMap = null;
		System.out.println(sysParam);
		for(SysParam sp : sysParam){
			if("1".equals(sp.getSysParamType())){
				
				String sql = sp.getSysParamValue();
				System.out.println(sql);
				List<SysParam> otherSysParam = sysParamMapper.selectOtherSysParam(sql);
				System.out.println(otherSysParam);
				fieldMap = new HashMap<String,String>();
				
				for(SysParam osp : otherSysParam){
					fieldMap.put(osp.getSysParamValue(), osp.getSysParamText());
				}
				
				sysParamMap.put(sp.getSysParamField(), fieldMap);
				
			}else{
				if(!sysParamMap.containsKey(sp.getSysParamField())){
					fieldMap = new HashMap<String,String>();
					fieldMap.put(sp.getSysParamValue(), sp.getSysParamText());
					sysParamMap.put(sp.getSysParamField(), fieldMap);
				}else{
					fieldMap = (Map<String, String>) sysParamMap.get(sp.getSysParamField());
					fieldMap.put(sp.getSysParamValue(), sp.getSysParamText());
					
				}
			}
		}
		
		return sysParamMap;
	}

}
