package com.bootdo.doll.dao;

import com.bootdo.doll.domain.ItemDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-17 15:17:23
 */
@Mapper
public interface ItemDao {

	ItemDO get(Long id);
	
	List<ItemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ItemDO item);
	
	int update(ItemDO item);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    List<ItemDO> listAllItems(Map<String, Object> params);
}
