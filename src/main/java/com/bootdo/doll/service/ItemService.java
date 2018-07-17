package com.bootdo.doll.service;

import com.bootdo.doll.domain.ItemDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-17 15:17:23
 */
public interface ItemService {
	
	ItemDO get(Long id);
	
	List<ItemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ItemDO item);
	
	int update(ItemDO item);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
