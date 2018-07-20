package com.bootdo.doll.service.impl;

import com.bootdo.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.ItemDao;
import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.service.ItemService;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ItemDao itemDao;

    @Override
    public ItemDO get(Long id) {
        return itemDao.get(id);
    }

    @Override
    public List<ItemDO> list(Map<String, Object> map) {
        return itemDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return itemDao.count(map);
    }

    @Override
    public int save(ItemDO item) {
        if (StringUtils.isEmpty(item.getImgDetail()))
            item.setImgDetail("1×1");
        if (item.getTakeCry() == null)
            item.setTakeCry(99);
        if (item.getBuyPrice() == null)
            item.setBuyPrice(999);
        if (StringUtils.isEmpty(item.getIntro()))
            item.setIntro("这个物品还没有描述哦~");
        item.setGmtCreate(new Date());

        int res = 0;
        try {
            res = itemDao.save(item);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return res;
    }

    @Override
    public int update(ItemDO item) {
        return itemDao.update(item);
    }

    @Override
    public int remove(Long id) {
        return itemDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return itemDao.batchRemove(ids);
    }

    @Override
    public List<ItemDO> listAllItems(Map<String, Object> params) {
        return itemDao.listAllItems(params);
    }

}
