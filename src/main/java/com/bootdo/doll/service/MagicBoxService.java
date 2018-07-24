package com.bootdo.doll.service;

import com.bootdo.doll.domain.MagicBoxDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-23 16:42:26
 */
public interface MagicBoxService {
	
	MagicBoxDO get(Long id);
	
	List<MagicBoxDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MagicBoxDO magicBox);
	
	int update(MagicBoxDO magicBox);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
