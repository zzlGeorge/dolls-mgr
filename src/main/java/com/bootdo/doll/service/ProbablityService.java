package com.bootdo.doll.service;

import com.bootdo.common.utils.Query;
import com.bootdo.doll.domain.ProbablityDO;
import com.bootdo.doll.service.bo.GashaponItemPbBO;
import com.bootdo.doll.service.bo.ItemProbBO;

import java.util.List;
import java.util.Map;

/**
 * 随机概率表
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-19 17:46:25
 */
public interface ProbablityService {
	
	ProbablityDO get(Long id);
	
	List<ProbablityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProbablityDO probablity);
	
	int update(ProbablityDO probablity);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    List<GashaponItemPbBO> listGashaponItemPb(Map<String, Object> map);

	int countGashaponItemPb(Map<String, Object> map);

	List<ItemProbBO> listItemProb(Map<String, Object> map);
}
