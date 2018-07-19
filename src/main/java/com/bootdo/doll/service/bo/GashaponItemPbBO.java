package com.bootdo.doll.service.bo;

import com.bootdo.doll.domain.GashaponDO;

import java.util.List;

/**
 * @author mading
 * @desc 扭蛋机中各商品概率信息
 * @date 2018/7/19
 **/
public class GashaponItemPbBO {
//    private GashaponDO gashaponDO;

    private Long bizId;
    //扭蛋机的名称
    private String name;
    //扭蛋机的描述
    private String intro;
    //扭蛋机的子描述，第二级别的描述
    private String subIntro;
    //扭蛋机的图片
    private String pic;

    private List<ItemProbBO> itemProbBOS;

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
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
