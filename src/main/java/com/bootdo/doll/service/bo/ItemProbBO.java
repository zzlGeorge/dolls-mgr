package com.bootdo.doll.service.bo;

import com.bootdo.doll.domain.ProbablityDO;

/**
 * @author mading
 * @desc 商品和概率关联
 * @date 2018/7/19
 **/
public class ItemProbBO {
    //商品
    private Long bizId;
    private String img;
    private String name;
    private String intro;

    //概率
    private ProbablityDO probablityDO;

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public ProbablityDO getProbablityDO() {
        return probablityDO;
    }

    public void setProbablityDO(ProbablityDO probablityDO) {
        this.probablityDO = probablityDO;
    }
}
