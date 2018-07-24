package com.bootdo.doll.dao;

import com.bootdo.doll.domain.MagicBoxDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-23 16:42:26
 */
@Mapper
public interface MagicBoxDao {

	MagicBoxDO get(Long id);
	
	List<MagicBoxDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MagicBoxDO magicBox);
	
	int update(MagicBoxDO magicBox);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
