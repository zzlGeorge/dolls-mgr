package com.bootdo.doll.domain;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-23 16:42:26
 */
public class MagicBoxDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private Long id;
    //业务id
    @NotNull(message = "bizId不能为空")
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
     * 设置：业务id
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * 获取：业务id
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：简介
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * 获取：简介
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置：图片
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取：图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置：最低价格
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取：最低价格
     */
    public String getPrice() {
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

    /**
     * 设置：权重
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * 获取：权重
     */
    public String getWeight() {
        return weight;
    }
}
