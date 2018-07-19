package com.bootdo.doll.service.impl;

import com.bootdo.common.utils.Query;
import com.bootdo.doll.service.bo.GashaponItemPbBO;
import com.bootdo.doll.service.bo.ItemProbBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.ProbablityDao;
import com.bootdo.doll.domain.ProbablityDO;
import com.bootdo.doll.service.ProbablityService;



@Service
public class ProbablityServiceImpl implements ProbablityService {
	@Autowired
	private ProbablityDao probablityDao;
	
	@Override
	public ProbablityDO get(Long id){
		return probablityDao.get(id);
	}
	
	@Override
	public List<ProbablityDO> list(Map<String, Object> map){
		return probablityDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return probablityDao.count(map);
	}
	
	@Override
	public int save(ProbablityDO probablity){
		return probablityDao.save(probablity);
	}
	
	@Override
	public int update(ProbablityDO probablity){
		return probablityDao.update(probablity);
	}
	
	@Override
	public int remove(Long id){
		return probablityDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return probablityDao.batchRemove(ids);
	}

    @Override
    public List<GashaponItemPbBO> listGashaponItemPb(Map<String, Object> map) {
        return probablityDao.listGashaponItemPb(map);
    }

	@Override
	public int countGashaponItemPb(Map<String, Object> map) {
		return probablityDao.countGashaponItemPb(map);
	}

	@Override
	public List<ItemProbBO> listItemProb(Map<String, Object> map) {
		return probablityDao.listItemProb(map);
	}

}
