package com.bootdo.doll.service.bo;

import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.domain.ShopDO;

/**
 * @author mading
 * @desc
 * @date 2018/7/20
 **/
public class ItemShopBO {
    private ItemDO item;

    private ShopDO shop;

    public ItemDO getItem() {
        return item;
    }

    public void setItem(ItemDO item) {
        this.item = item;
    }

    public ShopDO getShop() {
        return shop;
    }

    public void setShop(ShopDO shop) {
        this.shop = shop;
    }
}
