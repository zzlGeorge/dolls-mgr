package com.bootdo.doll.service.bo;

import java.util.Date;

/**
 * @author mading
 * @desc
 * @date 2018/7/24
 **/
public class MagicBoxBO {
    private Long id;
    //业务id
    private Long bizId;
    //名称
    private String name;
    //简介
    private String intro;
    //图片
    private String img;
    //最低价格
    private String price;
    //生成时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModify;
    //权重
    private String weight;

    private int ruleCount;//规则数量

    private int itemCount;//商品数量

    private int itemMaxLevel; //商品最大等级

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getRuleCount() {
        return ruleCount;
    }

    public void setRuleCount(int ruleCount) {
        this.ruleCount = ruleCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getItemMaxLevel() {
        return itemMaxLevel;
    }

    public void setItemMaxLevel(int itemMaxLevel) {
        this.itemMaxLevel = itemMaxLevel;
    }
}
