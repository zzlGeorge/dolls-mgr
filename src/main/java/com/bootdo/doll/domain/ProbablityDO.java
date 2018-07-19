package com.bootdo.doll.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 随机概率表
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-19 17:46:25
 */
public class ProbablityDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
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
	 * 设置：物品id,如果是金币则为0
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	/**
	 * 获取：物品id,如果是金币则为0
	 */
	public Long getItemId() {
		return itemId;
	}
	/**
	 * 设置：概率
	 */
	public void setProbability(Double probability) {
		this.probability = probability;
	}
	/**
	 * 获取：概率
	 */
	public Double getProbability() {
		return probability;
	}
	/**
	 * 设置：个数
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：个数
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：等级。1-最高级别，10连抽出 
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：等级。1-最高级别，10连抽出 
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：
	 */
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}
	/**
	 * 获取：
	 */
	public Integer getItemPrice() {
		return itemPrice;
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
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**
	 * 获取：
	 */
	public Date getGmtModify() {
		return gmtModify;
	}
}
