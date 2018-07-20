package com.bootdo.doll.dao;

import com.bootdo.doll.domain.ShopDO;

import java.util.List;
import java.util.Map;

import com.bootdo.doll.service.bo.ItemShopBO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-20 14:36:47
 */
@Mapper
public interface ShopDao {

	ShopDO get(Long id);
	
	List<ShopDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ShopDO shop);
	
	int update(ShopDO shop);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	/**
	 * @param map
	 * @return
	 */
    List<ItemShopBO> listShopItem(Map<String, Object> map);
}
