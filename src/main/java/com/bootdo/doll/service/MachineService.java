package com.bootdo.doll.service;

import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.domain.MachineDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-17 18:06:32
 */
public interface MachineService {
	
	MachineDO get(Long id);
	
	List<MachineDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MachineDO machine);
	
	int update(MachineDO machine);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    int saveNew(MachineDO machine, ItemDO item);
}
