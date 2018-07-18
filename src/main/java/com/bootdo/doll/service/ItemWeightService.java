package com.bootdo.doll.service;

import com.bootdo.common.utils.R;
import com.bootdo.doll.domain.ItemWeightDO;

import java.util.List;
import java.util.Map;

/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-18 19:37:00
 */
public interface ItemWeightService {

    ItemWeightDO get(Long id);

    List<ItemWeightDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    R save(ItemWeightDO itemWeight, R Result);

    int update(ItemWeightDO itemWeight);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
