package com.bootdo.doll.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @author mading
 * @desc 错误码枚举以ERR开头；警告以WARN开头；提示信息以MSG开头。严重程度依次递减
 * @date 2018/7/18
 **/
public enum DollReturnCode {

    //上新娃娃
    WARN_IMG_ITEMIMG_NOT_REPEAT("00000", "img，item_img 不能重复", "img，item_img 不能重复"),
    WARN_TAKECRY_GREATER_THAN_PRICE("00001", "price 必须大于 take_cry", "price 必须大于 take_cry"),
    WARN_VIP_LIMIT_MUST_EXIST("00002", "buy_price > 10的 必须有 vip_limit", "buy_price > 10的 必须有 vip_limit"),
    ERROR_ITEM_ID_INVALID("00003", "biz_id在doll_item表里没有对应！", "biz_id在doll_item表里没有对应！"),

    ERROR_WRITE_ITEM_WEIGHT("00004", "非法写入数据库，未再产品表中找到产品！", "非法写入数据库，未再产品表中找到产品！"),
    ERROR_REPEAT_WRITE("00005", "数据表中已有对应产品权重，不要重写！", "数据表中已有对应产品权重，不要重写！"),
    ;

    /**
     * 枚举编码
     */
    private String code;

    /**
     * 枚举详情
     */
    private String description;

    /**
     * 错误枚举显示
     */
    private String resultView;

    /**
     * 构造方法
     *
     * @param code        枚举编号
     * @param description 枚举详情
     */
    DollReturnCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * @param code        枚举编号
     * @param description 枚举详情
     * @param resultView  错误结果提示文案
     */
    DollReturnCode(String code, String description, String resultView) {
        this.code = code;
        this.description = description;
        this.resultView = resultView;
    }

    /**
     * 根据code取得枚举值
     *
     * @param code
     * @return
     */
    public static DollReturnCode getDollReturnCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (DollReturnCode s : DollReturnCode.values()) {
            if (s.getCode().equals(code)) {
                return s;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getResultView() {
        return resultView;
    }
}
