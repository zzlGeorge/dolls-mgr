package com.bootdo.doll.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.GashaponDao;
import com.bootdo.doll.domain.GashaponDO;
import com.bootdo.doll.service.GashaponService;



@Service
public class GashaponServiceImpl implements GashaponService {
	@Autowired
	private GashaponDao gashaponDao;
	
	@Override
	public GashaponDO get(Long id){
		return gashaponDao.get(id);
	}
	
	@Override
	public List<GashaponDO> list(Map<String, Object> map){
		return gashaponDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return gashaponDao.count(map);
	}
	
	@Override
	public int save(GashaponDO gashapon){
		return gashaponDao.save(gashapon);
	}
	
	@Override
	public int update(GashaponDO gashapon){
		return gashaponDao.update(gashapon);
	}
	
	@Override
	public int remove(Long id){
		return gashaponDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return gashaponDao.batchRemove(ids);
	}
	
}
