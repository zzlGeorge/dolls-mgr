package com.bootdo.doll.service;

import com.bootdo.doll.domain.ProbablityDO;

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
}
