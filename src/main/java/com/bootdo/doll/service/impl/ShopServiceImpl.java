package com.bootdo.doll.service.impl;

import com.bootdo.common.exception.BDException;
import com.bootdo.doll.constant.DollReturnCode;
import com.bootdo.doll.dao.ItemDao;
import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.service.bo.ItemShopBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.ShopDao;
import com.bootdo.doll.domain.ShopDO;
import com.bootdo.doll.service.ShopService;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Autowired
    private ItemDao itemDao;

    @Override
    public ShopDO get(Long id) {
        return shopDao.get(id);
    }

    @Override
    public List<ShopDO> list(Map<String, Object> map) {
        return shopDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return shopDao.count(map);
    }

    @Override
    public int save(ShopDO shop) {

        //校验兑换商店中的item_id是否在doll_item中不存在
        ItemDO item = itemDao.get(shop.getItemId());

        validateShopItem(item,shop);

        shop.setGmtCreate(new Date());
        shop.setGmtModify(new Date());
        return shopDao.save(shop);
    }

    @Override
    public int update(ShopDO shop) {

        ItemDO item = itemDao.get(shop.getItemId());
        validateShopItem(item,shop);

        shop.setGmtModify(new Date());
        return shopDao.update(shop);
    }

    @Override
    public int remove(Long id) {
        return shopDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return shopDao.batchRemove(ids);
    }

    @Override
    public List<ItemShopBO> listShopItem(Map<String, Object> map) {
        return shopDao.listShopItem(map);
    }

    /**
     * 商店物品校验
     *
     * @param item
     * @param shop
     */
    private void validateShopItem(ItemDO item, ShopDO shop) {
        if (item == null) {
            throw new BDException(DollReturnCode.WARN_SHOP_ITEM_EMPTY.getDescription());
        }
        //校验changable >0时 change_point<1
        if (shop.getChangable() > 0 && shop.getChangePoint() < 1) {
            throw new BDException(DollReturnCode.ERROR_SHOP_CHANGEABLE.getDescription());
        }
        //校验purchasable >0时 purchase_point<1
        if (shop.getPurchasable() > 0 && shop.getPurchasePoint() < 1) {
            throw new BDException(DollReturnCode.ERROR_SHOP_SCORE_CHANGEABLE.getDescription());
        }
        //校验折损率>30%（只有娃娃类型的两个可以例外）
        if (shop.getPurchasable() > 0 && shop.getChangePoint() * 1.3 > shop.getPurchasePoint()) {
            throw new BDException(DollReturnCode.WARN_SHOP_CHANGEABLE_DISCOUNT.getDescription());
        }
        //校验兑换积分是否大于购买价格的5倍
        if (shop.getPurchasable() > 0 && item.getBuyPrice() * 5 < shop.getChangePoint()) {
            throw new BDException(DollReturnCode.WARN_SHOP_BUY_PRICE_5_LESS.getDescription());
        }
    }

}
