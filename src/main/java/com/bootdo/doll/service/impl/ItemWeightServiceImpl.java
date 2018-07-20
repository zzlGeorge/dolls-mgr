package com.bootdo.doll.service.impl;

import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.doll.constant.DollReturnCode;
import com.bootdo.doll.dao.ItemDao;
import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.service.bo.ItemWeightBO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.ItemWeightDao;
import com.bootdo.doll.domain.ItemWeightDO;
import com.bootdo.doll.service.ItemWeightService;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ItemWeightServiceImpl implements ItemWeightService {
    @Autowired
    private ItemWeightDao itemWeightDao;

    @Autowired
    private ItemDao itemDao;

    @Override
    public ItemWeightDO get(Long id) {
        return itemWeightDao.get(id);
    }

    @Override
    public List<ItemWeightDO> list(Map<String, Object> map) {
        return itemWeightDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return itemWeightDao.count(map);
    }

    @Override
    public R save(ItemWeightDO itemWeight, R result) {
        ItemDO itemDO = itemDao.get(itemWeight.getItemId());

        Map<String, Object> param = new HashMap<>();
        param.put("itemId", itemWeight.getItemId());
        List<ItemWeightDO> itemWeightDOList = itemWeightDao.list(param);

        if (itemDO == null) {//找不到对应娃娃
            result = R.error(DollReturnCode.ERROR_WRITE_ITEM_WEIGHT.getDescription());
            result.put("error", 1);//报错
            return result;
        }

        if (!CollectionUtils.isEmpty(itemWeightDOList)) {//数据表中已经有数据了
            result = R.error(DollReturnCode.ERROR_REPEAT_WRITE.getDescription());
            result.put("error", 1);//报错
            return result;
        }

        itemWeight.setGmtCreate(new Date());
        itemWeight.setGmtModify(new Date());
        itemWeightDao.save(itemWeight);
        return result;
    }

    @Override
    public int update(ItemWeightDO itemWeight) {
        return itemWeightDao.update(itemWeight);
    }

    @Override
    public int remove(Long id) {
        return itemWeightDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return itemWeightDao.batchRemove(ids);
    }

    @Override
    public List<ItemWeightBO> queryItemAndWeight(Query query) {
        return itemWeightDao.queryItemAndWeight(query);
    }

}
