package com.bootdo.doll.service.bo;

import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.domain.MagicItemDO;

/**
 * @author mading
 * @desc
 * @date 2018/7/23
 **/
public class MagicItemBO {
    private ItemDO itemDO;

    private MagicItemDO magicItemDO;


    public ItemDO getItemDO() {
        return itemDO;
    }

    public void setItemDO(ItemDO itemDO) {
        this.itemDO = itemDO;
    }

    public MagicItemDO getMagicItemDO() {
        return magicItemDO;
    }

    public void setMagicItemDO(MagicItemDO magicItemDO) {
        this.magicItemDO = magicItemDO;
    }
}
