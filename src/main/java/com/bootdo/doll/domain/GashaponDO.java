package com.bootdo.doll.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-19 17:04:41
 */
public class GashaponDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//业务id
	private Long bizId;
	//扭蛋机的名称
	private String name;
	//扭蛋机的描述
	private String intro;
	//扭蛋机的子描述，第二级别的描述
	private String subIntro;
	//扭蛋机的图片
	private String pic;
	//单次需要多少蛋券
	private Integer priceOnce;
	//排序
	private Integer weight;
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
	 * 设置：扭蛋机的名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：扭蛋机的名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：扭蛋机的描述
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：扭蛋机的描述
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：扭蛋机的子描述，第二级别的描述
	 */
	public void setSubIntro(String subIntro) {
		this.subIntro = subIntro;
	}
	/**
	 * 获取：扭蛋机的子描述，第二级别的描述
	 */
	public String getSubIntro() {
		return subIntro;
	}
	/**
	 * 设置：扭蛋机的图片
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * 获取：扭蛋机的图片
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * 设置：单次需要多少蛋券
	 */
	public void setPriceOnce(Integer priceOnce) {
		this.priceOnce = priceOnce;
	}
	/**
	 * 获取：单次需要多少蛋券
	 */
	public Integer getPriceOnce() {
		return priceOnce;
	}
	/**
	 * 设置：排序
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	/**
	 * 获取：排序
	 */
	public Integer getWeight() {
		return weight;
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
