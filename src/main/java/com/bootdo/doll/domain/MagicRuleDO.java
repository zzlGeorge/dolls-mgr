package com.bootdo.doll.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-23 16:42:27
 */
public class MagicRuleDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //ID
    private Long id;
    //魔法盒id
    @NotNull(message = "boxId不能为空！")
    private Long boxId;
    //业务类型
    private String bizType;
    //规则
    private Integer rule;
    //规则约定值
    private Integer value;
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
     * 设置：业务类型
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
     * 获取：业务类型
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 设置：规则
     */
    public void setRule(Integer rule) {
        this.rule = rule;
    }

    /**
     * 获取：规则
     */
    public Integer getRule() {
        return rule;
    }

    /**
     * 设置：规则约定值
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 获取：规则约定值
     */
    public Integer getValue() {
        return value;
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
