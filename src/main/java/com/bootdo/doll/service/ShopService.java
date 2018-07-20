package com.bootdo.doll.service;

import com.bootdo.common.utils.Query;
import com.bootdo.doll.domain.ShopDO;
import com.bootdo.doll.service.bo.ItemShopBO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-20 14:36:47
 */
public interface ShopService {
	
	ShopDO get(Long id);
	
	List<ShopDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ShopDO shop);
	
	int update(ShopDO shop);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<ItemShopBO> listShopItem(Map<String, Object> map);
}
