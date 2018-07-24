package com.bootdo.doll.service.impl;

import com.bootdo.common.exception.BDException;
import com.bootdo.doll.constant.DollReturnCode;
import com.bootdo.doll.dao.ItemDao;
import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.service.bo.MagicBoxBO;
import com.bootdo.doll.service.bo.MagicItemBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.MagicItemDao;
import com.bootdo.doll.domain.MagicItemDO;
import com.bootdo.doll.service.MagicItemService;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MagicItemServiceImpl implements MagicItemService {
    @Autowired
    private MagicItemDao magicItemDao;

    @Autowired
    private ItemDao itemDao;

    @Override
    public MagicItemDO get(Long id) {
        return magicItemDao.get(id);
    }

    @Override
    public List<MagicItemDO> list(Map<String, Object> map) {
        return magicItemDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return magicItemDao.count(map);
    }

    @Override
    public int save(MagicItemDO magicItem) {
        ItemDO item = itemDao.get(magicItem.getItemId());
        if (item == null)
            throw new BDException("商品不存在，请检查！");

        if (magicItem.getPrice() < item.getBuyPrice() * 2)
            throw new BDException(DollReturnCode.WARN_MAGIC_PRICE_LESS.getDescription());

        magicItem.setGmtCreate(new Date());
        magicItem.setGmtModify(new Date());
        return magicItemDao.save(magicItem);
    }

    @Override
    public int update(MagicItemDO magicItem) {
        ItemDO item = itemDao.get(magicItem.getItemId());
        if (magicItem.getPrice() < item.getBuyPrice() * 2)
            throw new BDException(DollReturnCode.WARN_MAGIC_PRICE_LESS.getDescription());

        magicItem.setGmtModify(new Date());
        return magicItemDao.update(magicItem);
    }

    @Override
    public int remove(Long id) {
        return magicItemDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return magicItemDao.batchRemove(ids);
    }

    @Override
    public List<MagicItemBO> listMagicItems(Map<String, Object> map) {
        return magicItemDao.listMagicItems(map);
    }

    @Override
    public List<MagicBoxBO> listMagicBoxInfo(Map<String, Object> map) {
        return magicItemDao.listMagicBoxInfo(map);
    }

}
