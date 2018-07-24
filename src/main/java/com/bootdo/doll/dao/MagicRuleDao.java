package com.bootdo.doll.dao;

import com.bootdo.doll.domain.MagicRuleDO;

import java.util.List;
import java.util.Map;

import com.bootdo.doll.service.bo.MagicBoxBO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-23 16:42:27
 */
@Mapper
public interface MagicRuleDao {

	MagicRuleDO get(Long id);
	
	List<MagicRuleDO> list(Map<String,Object> map);

	List<MagicBoxBO> listMagicBox(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MagicRuleDO magicRule);
	
	int update(MagicRuleDO magicRule);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
