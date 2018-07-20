package com.bootdo.doll.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-20 14:36:47
 */
public class ShopDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //商品编号
    @NotNull(message = "itemId不能为空")
    private Long itemId;
    //0表示不限时，1表示限时
    private String tag;
    //客户端依照这个做客户端展示排序，不能为空
    @NotNull(message = "weight不能为空")
    private Integer weight;
    //兑换积分
    @NotNull(message = "changePoint不能为空")
    private Integer changePoint;
    //商品能购买多少积分
    @NotNull(message = "purchasePoint不能为空")
    private Integer purchasePoint;
    //商品能不能购买积分，1表示可以购买，0表示不能购买积分
    @NotNull(message = "purchasable不能为空")
    private Integer purchasable;
    //积分兑换商品，1表示可兑换，0表示不可兑换
    @NotNull(message = "changable不能为空")
    private Integer changable;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModify;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：商品编号
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取：商品编号
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 设置：0表示不限时，1表示限时
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 获取：0表示不限时，1表示限时
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置：客户端依照这个做客户端展示排序，不能为空
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取：客户端依照这个做客户端展示排序，不能为空
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置：兑换积分
     */
    public void setChangePoint(Integer changePoint) {
        this.changePoint = changePoint;
    }

    /**
     * 获取：兑换积分
     */
    public Integer getChangePoint() {
        return changePoint;
    }

    /**
     * 设置：商品能购买多少积分
     */
    public void setPurchasePoint(Integer purchasePoint) {
        this.purchasePoint = purchasePoint;
    }

    /**
     * 获取：商品能购买多少积分
     */
    public Integer getPurchasePoint() {
        return purchasePoint;
    }

    /**
     * 设置：商品能不能购买积分，1表示可以购买，0表示不能购买积分
     */
    public void setPurchasable(Integer purchasable) {
        this.purchasable = purchasable;
    }

    /**
     * 获取：商品能不能购买积分，1表示可以购买，0表示不能购买积分
     */
    public Integer getPurchasable() {
        return purchasable;
    }

    /**
     * 设置：积分兑换商品，1表示可兑换，0表示不可兑换
     */
    public void setChangable(Integer changable) {
        this.changable = changable;
    }

    /**
     * 获取：积分兑换商品，1表示可兑换，0表示不可兑换
     */
    public Integer getChangable() {
        return changable;
    }

    /**
     * 设置：创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取：创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置：修改时间
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 获取：修改时间
     */
    public Date getGmtModify() {
        return gmtModify;
    }
}
