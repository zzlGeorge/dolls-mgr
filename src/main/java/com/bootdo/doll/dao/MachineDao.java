package com.bootdo.doll.dao;

import com.bootdo.doll.domain.MachineDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-17 18:06:32
 */
@Mapper
public interface MachineDao {

	MachineDO get(Long id);
	
	List<MachineDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MachineDO machine);
	
	int update(MachineDO machine);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
