package com.bootdo.doll.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-18 19:37:00
 */
public class ItemWeightDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long itemId;
	//
	private Integer zhuaZhua;
	//
	private Integer suiShen;
	//
	private Integer zaiJia;
	//
	private Integer keAi;
	//
	private Integer kuHei;
	//
	private Integer dingDong;
	//
	private Integer chaoRen;
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
	 * 设置：
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	/**
	 * 获取：
	 */
	public Long getItemId() {
		return itemId;
	}
	/**
	 * 设置：
	 */
	public void setZhuaZhua(Integer zhuaZhua) {
		this.zhuaZhua = zhuaZhua;
	}
	/**
	 * 获取：
	 */
	public Integer getZhuaZhua() {
		return zhuaZhua;
	}
	/**
	 * 设置：
	 */
	public void setSuiShen(Integer suiShen) {
		this.suiShen = suiShen;
	}
	/**
	 * 获取：
	 */
	public Integer getSuiShen() {
		return suiShen;
	}
	/**
	 * 设置：
	 */
	public void setZaiJia(Integer zaiJia) {
		this.zaiJia = zaiJia;
	}
	/**
	 * 获取：
	 */
	public Integer getZaiJia() {
		return zaiJia;
	}
	/**
	 * 设置：
	 */
	public void setKeAi(Integer keAi) {
		this.keAi = keAi;
	}
	/**
	 * 获取：
	 */
	public Integer getKeAi() {
		return keAi;
	}
	/**
	 * 设置：
	 */
	public void setKuHei(Integer kuHei) {
		this.kuHei = kuHei;
	}
	/**
	 * 获取：
	 */
	public Integer getKuHei() {
		return kuHei;
	}
	/**
	 * 设置：
	 */
	public void setDingDong(Integer dingDong) {
		this.dingDong = dingDong;
	}
	/**
	 * 获取：
	 */
	public Integer getDingDong() {
		return dingDong;
	}
	/**
	 * 设置：
	 */
	public void setChaoRen(Integer chaoRen) {
		this.chaoRen = chaoRen;
	}
	/**
	 * 获取：
	 */
	public Integer getChaoRen() {
		return chaoRen;
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
