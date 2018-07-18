package com.bootdo.doll.service.bo;

import com.bootdo.doll.domain.ItemDO;

import java.util.Date;

/**
 * @author mading
 * @desc
 * @date 2018/7/18
 **/
public class MachineBO {

    private Long id;
    //娃娃机id
    private Long machineId;
    //产品id
    private Long itemId;
    //娃娃机状态
    private String machineStatus;
    //娃娃机地址
    private String machineAddress;
    //房间
    private String chatRoom;
    //主摄像头
    private String mainCamera;
    //子摄像头
    private String subCamera;
    //mac地址
    private String machineMac;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModify;

    private ItemDO item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ItemDO getItem() {
        return item;
    }

    public void setItem(ItemDO item) {
        this.item = item;
    }
}
