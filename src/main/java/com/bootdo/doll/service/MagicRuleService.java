package com.bootdo.doll.service;

import com.bootdo.doll.domain.MagicRuleDO;
import com.bootdo.doll.service.bo.MagicBoxBO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-23 16:42:27
 */
public interface MagicRuleService {
	
	MagicRuleDO get(Long id);
	
	List<MagicRuleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MagicRuleDO magicRule);
	
	int update(MagicRuleDO magicRule);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<MagicBoxBO> listMagicBox(Map<String, Object> map);
}
