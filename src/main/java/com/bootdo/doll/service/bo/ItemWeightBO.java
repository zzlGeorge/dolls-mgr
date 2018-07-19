package com.bootdo.doll.service.bo;

import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.domain.ItemWeightDO;

/**
 * @author mading
 * @desc 产品和权重数据集合
 * @date 2018/7/19
 **/
public class ItemWeightBO {

    private ItemWeightDO itemWeightDO;

    private ItemDO itemDO;

    public ItemWeightDO getItemWeightDO() {
        return itemWeightDO;
    }

    public void setItemWeightDO(ItemWeightDO itemWeightDO) {
        this.itemWeightDO = itemWeightDO;
    }

    public ItemDO getItemDO() {
        return itemDO;
    }

    public void setItemDO(ItemDO itemDO) {
        this.itemDO = itemDO;
    }
}
