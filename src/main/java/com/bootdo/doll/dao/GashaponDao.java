package com.bootdo.doll.dao;

import com.bootdo.doll.domain.GashaponDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-19 17:04:41
 */
@Mapper
public interface GashaponDao {

	GashaponDO get(Long id);
	
	List<GashaponDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(GashaponDO gashapon);
	
	int update(GashaponDO gashapon);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
