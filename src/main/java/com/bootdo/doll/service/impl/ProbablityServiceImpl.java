package com.bootdo.doll.service.impl;

import com.bootdo.common.exception.BDException;
import com.bootdo.doll.constant.DollReturnCode;
import com.bootdo.doll.dao.ItemDao;
import com.bootdo.doll.dao.ShopDao;
import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.domain.ShopDO;
import com.bootdo.doll.service.bo.GashaponItemPbBO;
import com.bootdo.doll.service.bo.ItemProbBO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.ProbablityDao;
import com.bootdo.doll.domain.ProbablityDO;
import com.bootdo.doll.service.ProbablityService;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProbablityServiceImpl implements ProbablityService {
    @Autowired
    private ProbablityDao probablityDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ShopDao shopDao;

    @Override
    public ProbablityDO get(Long id) {
        return probablityDao.get(id);
    }

    @Override
    public List<ProbablityDO> list(Map<String, Object> map) {
        return probablityDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return probablityDao.count(map);
    }

    @Override
    public int save(ProbablityDO probablity) {

        validateProbablity(probablity);

        probablity.setGmtCreate(new Date());
        probablity.setGmtModify(new Date());
        return probablityDao.save(probablity);
    }

    @Override
    public int update(ProbablityDO probablity) {

        if (probablity.getItemId() != 0) {//非金币物品,0代表金币，所以不用拦截
            ItemDO item = itemDao.get(probablity.getItemId());

            //连表校验扭蛋中的物品在 item 里是不是都有
            if (item == null) {
                throw new BDException(DollReturnCode.ERROR_GA_NO_ITEM.getDescription());
            }

            //校验物品在扭蛋中的价格必须高于物品买价的2倍
            if (probablity.getItemPrice() <= item.getBuyPrice() * 2) {
                throw new BDException(DollReturnCode.WARN_GA_INVALID_ITEM_PRICE.getDescription());
            }

        }

        probablity.setGmtModify(new Date());
        return probablityDao.update(probablity);
    }

    @Override
    public int remove(Long id) {
        return probablityDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return probablityDao.batchRemove(ids);
    }

    @Override
    public List<GashaponItemPbBO> listGashaponItemPb(Map<String, Object> map) {
        return probablityDao.listGashaponItemPb(map);
    }

    @Override
    public int countGashaponItemPb(Map<String, Object> map) {
        return probablityDao.countGashaponItemPb(map);
    }

    @Override
    public List<ItemProbBO> listItemProb(Map<String, Object> map) {
        return probablityDao.listItemProb(map);
    }

    private void validateProbablity(ProbablityDO probablity) {

        if (probablity.getItemId() != 0) {//非金币物品,0代表金币，所以不用拦截
            ItemDO item = itemDao.get(probablity.getItemId());

            //连表校验扭蛋中的物品在 item 里是不是都有
            if (item == null) {
                throw new BDException(DollReturnCode.ERROR_GA_NO_ITEM.getDescription());
            }

            //校验物品在扭蛋中的价格必须高于物品买价的2倍
            if (probablity.getItemPrice() <= item.getBuyPrice() * 2) {
                throw new BDException(DollReturnCode.WARN_GA_INVALID_ITEM_PRICE.getDescription());
            }

            //连表检查物品是否出现在 shop 中
            if (item.getBuyPrice() <= 999 && item.getBizId() != 405 && item.getBizId() != 406) {
                Map<String, Object> param = new HashMap<>();
                param.put("itemId", probablity.getItemId());
                List<ShopDO> shopDOList = shopDao.list(param);
                if (!CollectionUtils.isEmpty(shopDOList)) {
                    throw new BDException(DollReturnCode.WARN_GA_SHOP_ITEM_APPEAR.getDescription());
                }
            }

        }

    }

}
