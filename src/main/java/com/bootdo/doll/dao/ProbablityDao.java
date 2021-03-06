package com.bootdo.doll.dao;

import com.bootdo.doll.domain.ProbablityDO;

import java.util.List;
import java.util.Map;

import com.bootdo.doll.service.bo.GashaponItemPbBO;
import com.bootdo.doll.service.bo.ItemProbBO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 随机概率表
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-19 17:46:25
 */
@Mapper
public interface ProbablityDao {

	ProbablityDO get(Long id);
	
	List<ProbablityDO> list(Map<String,Object> map);

	/** 分页数据有问题，无法做服务端分页 */
	List<GashaponItemPbBO> listGashaponItemPb(Map<String,Object> map);

	int countGashaponItemPb(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProbablityDO probablity);
	
	int update(ProbablityDO probablity);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<ItemProbBO> listItemProb(Map<String, Object> map);
}
