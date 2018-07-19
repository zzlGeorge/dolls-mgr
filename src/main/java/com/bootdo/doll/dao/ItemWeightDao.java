package com.bootdo.doll.dao;

import com.bootdo.common.utils.Query;
import com.bootdo.doll.domain.ItemWeightDO;

import java.util.List;
import java.util.Map;

import com.bootdo.doll.service.bo.ItemWeightBO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-18 19:37:00
 */
@Mapper
public interface ItemWeightDao {

	ItemWeightDO get(Long id);
	
	List<ItemWeightDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ItemWeightDO itemWeight);
	
	int update(ItemWeightDO itemWeight);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<ItemWeightBO> queryItemAndWeight(Query query);
}
