package com.bootdo.doll.service;

import com.bootdo.common.utils.Query;
import com.bootdo.doll.domain.MagicItemDO;
import com.bootdo.doll.service.bo.MagicBoxBO;
import com.bootdo.doll.service.bo.MagicItemBO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-23 16:42:27
 */
public interface MagicItemService {
	
	MagicItemDO get(Long id);
	
	List<MagicItemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MagicItemDO magicItem);
	
	int update(MagicItemDO magicItem);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    List<MagicItemBO> listMagicItems(Map<String, Object> map);

    List<MagicBoxBO> listMagicBoxInfo(Map<String, Object> map);
}
