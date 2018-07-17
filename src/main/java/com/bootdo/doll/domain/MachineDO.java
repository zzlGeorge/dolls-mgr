package com.bootdo.doll.domain;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;


/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-17 18:06:32
 */
public class MachineDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
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
     * 设置：娃娃机id
     */
    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    /**
     * 获取：娃娃机id
     */
    public Long getMachineId() {
        return machineId;
    }

    /**
     * 设置：产品id
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取：产品id
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 设置：娃娃机状态
     */
    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }

    /**
     * 获取：娃娃机状态
     */
    public String getMachineStatus() {
        return machineStatus;
    }

    /**
     * 设置：娃娃机地址
     */
    public void setMachineAddress(String machineAddress) {
        this.machineAddress = machineAddress;
    }

    /**
     * 获取：娃娃机地址
     */
    public String getMachineAddress() {
        return machineAddress;
    }

    /**
     * 设置：房间
     */
    public void setChatRoom(String chatRoom) {
        this.chatRoom = chatRoom;
    }

    /**
     * 获取：房间
     */
    public String getChatRoom() {
        return chatRoom;
    }

    /**
     * 设置：主摄像头
     */
    public void setMainCamera(String mainCamera) {
        this.mainCamera = mainCamera;
    }

    /**
     * 获取：主摄像头
     */
    public String getMainCamera() {
        return mainCamera;
    }

    /**
     * 设置：子摄像头
     */
    public void setSubCamera(String subCamera) {
        this.subCamera = subCamera;
    }

    /**
     * 获取：子摄像头
     */
    public String getSubCamera() {
        return subCamera;
    }

    /**
     * 设置：mac地址
     */
    public void setMachineMac(String machineMac) {
        this.machineMac = machineMac;
    }

    /**
     * 获取：mac地址
     */
    public String getMachineMac() {
        return machineMac;
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
