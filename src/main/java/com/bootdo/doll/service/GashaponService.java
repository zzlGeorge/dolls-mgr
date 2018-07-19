package com.bootdo.doll.service;

import com.bootdo.doll.domain.GashaponDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-19 17:04:41
 */
public interface GashaponService {
	
	GashaponDO get(Long id);
	
	List<GashaponDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GashaponDO gashapon);
	
	int update(GashaponDO gashapon);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
