package com.bootdo.doll.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-23 16:42:27
 */
public class MagicItemDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private Long id;
    //魔法盒id
    @NotNull(message = "boxId不能为空！")
    private Long boxId;
    //商品id
    @NotNull(message = "itemId不能为空！")
    private Long itemId;
    //物品级别
    private Integer level;
    //物品价格
    @NotNull(message = "price不能为空！")
    private Integer price;
    //生成时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModify;

    /**
     * 设置：ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：魔法盒id
     */
    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    /**
     * 获取：魔法盒id
     */
    public Long getBoxId() {
        return boxId;
    }

    /**
     * 设置：商品id
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取：商品id
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 设置：物品级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取：物品级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置：物品价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取：物品价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置：生成时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取：生成时间
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
