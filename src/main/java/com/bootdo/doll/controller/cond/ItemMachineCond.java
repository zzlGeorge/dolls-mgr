package com.bootdo.doll.controller.cond;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mading
 * @desc item与Machine组合
 * @date 2018/7/18
 **/
public class ItemMachineCond implements Serializable {
    private static final long serialVersionUID = 1L;

    //-------------------------Machine------------------------------

    //娃娃机id
    @NotNull(message = "machineId不能为空")
    private Long machineId;
    //产品id
    @NotNull(message = "产品biz_id不能为空")
    private Long itemId;
    //娃娃机状态
    private String machineStatus;
    //娃娃机地址
    @NotBlank(message = "机器地址不能为空")
    private String machineAddress;
    //房间
    @NotBlank(message = "chatRoom不能为空")
    private String chatRoom;
    //主摄像头
    @NotBlank(message = "主摄像头不能为空")
    private String mainCamera;
    //子摄像头
    @NotBlank(message = "子摄像头不能为空")
    private String subCamera;
    //mac地址
    private String machineMac;


    //-------------------------Item------------------------------

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

    @NotBlank(message = "bizType不能为空")
    private String bizType;
    //要求的vip级别
    private Integer vipLimit;
    //参加PK吗,1参加;0不参加
    @NotNull(message = "pk不能为空")
    private Integer pk;

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }

    public String getMachineAddress() {
        return machineAddress;
    }

    public void setMachineAddress(String machineAddress) {
        this.machineAddress = machineAddress;
    }

    public String getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(String chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String getMainCamera() {
        return mainCamera;
    }

    public void setMainCamera(String mainCamera) {
        this.mainCamera = mainCamera;
    }

    public String getSubCamera() {
        return subCamera;
    }

    public void setSubCamera(String subCamera) {
        this.subCamera = subCamera;
    }

    public String getMachineMac() {
        return machineMac;
    }

    public void setMachineMac(String machineMac) {
        this.machineMac = machineMac;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(String imgDetail) {
        this.imgDetail = imgDetail;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
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

    public String getChangeText() {
        return changeText;
    }

    public void setChangeText(String changeText) {
        this.changeText = changeText;
    }

    public Integer getTakeCry() {
        return takeCry;
    }

    public void setTakeCry(Integer takeCry) {
        this.takeCry = takeCry;
    }

    public Integer getChangeCry() {
        return changeCry;
    }

    public void setChangeCry(Integer changeCry) {
        this.changeCry = changeCry;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Double getRewardPercent() {
        return rewardPercent;
    }

    public void setRewardPercent(Double rewardPercent) {
        this.rewardPercent = rewardPercent;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Integer getVipLimit() {
        return vipLimit;
    }

    public void setVipLimit(Integer vipLimit) {
        this.vipLimit = vipLimit;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }
}
