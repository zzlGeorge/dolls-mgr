package com.bootdo.doll.service.bo;

import com.bootdo.doll.domain.ProbablityDO;

import java.util.Date;

/**
 * @author mading
 * @desc 商品和概率关联
 * @date 2018/7/19
 **/
public class ItemProbBO {
    //商品

    private Long itemBizId;
    private String img;
    private String itemName;
    private String itemIntro;

    //概率

    private Long id;
    //业务id
    private Long bizId;
    //物品id,如果是金币则为0
    private Long itemId;
    //概率
    private Double probability;
    //个数
    private Integer count;
    //等级。1-最高级别，10连抽出
    private Integer level;
    //
    private Integer itemPrice;
    //
    private Date gmtCreate;
    //
    private Date gmtModify;

    public Long getItemBizId() {
        return itemBizId;
    }

    public void setItemBizId(Long itemBizId) {
        this.itemBizId = itemBizId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemIntro() {
        return itemIntro;
    }

    public void setItemIntro(String itemIntro) {
        this.itemIntro = itemIntro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}
