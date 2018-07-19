package com.bootdo.doll.service.bo;

import com.bootdo.doll.domain.GashaponDO;

import java.util.List;

/**
 * @author mading
 * @desc 扭蛋机中各商品概率信息
 * @date 2018/7/19
 **/
public class GashaponItemPbBO {

    private Long gashaponBizId;
    //扭蛋机的名称
    private String gashaponName;
    //扭蛋机的描述
    private String gashaponIntro;
    //扭蛋机的子描述，第二级别的描述
    private String subIntro;
    //扭蛋机的图片
    private String pic;

    private List<ItemProbBO> itemProbBOS;

    public Long getGashaponBizId() {
        return gashaponBizId;
    }

    public void setGashaponBizId(Long gashaponBizId) {
        this.gashaponBizId = gashaponBizId;
    }

    public String getGashaponName() {
        return gashaponName;
    }

    public void setGashaponName(String gashaponName) {
        this.gashaponName = gashaponName;
    }

    public String getGashaponIntro() {
        return gashaponIntro;
    }

    public void setGashaponIntro(String gashaponIntro) {
        this.gashaponIntro = gashaponIntro;
    }

    public String getSubIntro() {
        return subIntro;
    }

    public void setSubIntro(String subIntro) {
        this.subIntro = subIntro;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public List<ItemProbBO> getItemProbBOS() {
        return itemProbBOS;
    }

    public void setItemProbBOS(List<ItemProbBO> itemProbBOS) {
        this.itemProbBOS = itemProbBOS;
    }
}
