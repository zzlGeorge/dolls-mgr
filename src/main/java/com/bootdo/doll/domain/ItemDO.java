package com.bootdo.doll.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-17 15:17:23
 */
public class ItemDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;

    @NotNull(message = "bizId不能为空")
    private Long bizId;
    //
    private String itemType;
    @NotBlank(message = "包名不能为空")
    private String packageName;
    @NotBlank(message = "img不能为空")
    private String img;
    @NotBlank(message = "imgDetail不能为空")
    private String imgDetail;
    @NotBlank(message = "imgDetail不能为空")
    private String itemImg;

    @NotBlank(message = "name不能为空")
    private String name;
    //
    private String intro;
    //
    private String changeText;
    //
    private Integer takeCry;
    //
    private Integer changeCry;
    //
    private Integer buyPrice;
    //
    private Integer price;
    //
    private String tag;
    //抓到娃娃的奖励百分比
    private Double rewardPercent;

    @NotNull(message = "weight不能为空")
    private Integer weight;
    //
    private Date gmtCreate;
    @NotBlank(message = "bizType不能为空")
    private String bizType;
    //要求的vip级别
    private Integer vipLimit;
    //参加PK吗,1参加;0不参加
    @NotNull(message = "pk不能为空")
    private Integer pk;

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
     * 设置：
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * 获取：
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * 设置：
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * 获取：
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * 设置：
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * 获取：
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * 设置：
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取：
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置：
     */
    public void setImgDetail(String imgDetail) {
        this.imgDetail = imgDetail;
    }

    /**
     * 获取：
     */
    public String getImgDetail() {
        return imgDetail;
    }

    /**
     * 设置：
     */
    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    /**
     * 获取：
     */
    public String getItemImg() {
        return itemImg;
    }

    /**
     * 设置：
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * 获取：
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置：
     */
    public void setChangeText(String changeText) {
        this.changeText = changeText;
    }

    /**
     * 获取：
     */
    public String getChangeText() {
        return changeText;
    }

    /**
     * 设置：
     */
    public void setTakeCry(Integer takeCry) {
        this.takeCry = takeCry;
    }

    /**
     * 获取：
     */
    public Integer getTakeCry() {
        return takeCry;
    }

    /**
     * 设置：
     */
    public void setChangeCry(Integer changeCry) {
        this.changeCry = changeCry;
    }

    /**
     * 获取：
     */
    public Integer getChangeCry() {
        return changeCry;
    }

    /**
     * 设置：
     */
    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * 获取：
     */
    public Integer getBuyPrice() {
        return buyPrice;
    }

    /**
     * 设置：
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取：
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置：
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 获取：
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置：抓到娃娃的奖励百分比
     */
    public void setRewardPercent(Double rewardPercent) {
        this.rewardPercent = rewardPercent;
    }

    /**
     * 获取：抓到娃娃的奖励百分比
     */
    public Double getRewardPercent() {
        return rewardPercent;
    }

    /**
     * 设置：
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取：
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置：
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取：
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置：
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
     * 获取：
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 设置：要求的vip级别
     */
    public void setVipLimit(Integer vipLimit) {
        this.vipLimit = vipLimit;
    }

    /**
     * 获取：要求的vip级别
     */
    public Integer getVipLimit() {
        return vipLimit;
    }

    /**
     * 设置：参加PK吗,1参加;0不参加
     */
    public void setPk(Integer pk) {
        this.pk = pk;
    }

    /**
     * 获取：参加PK吗,1参加;0不参加
     */
    public Integer getPk() {
        return pk;
    }
}
