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

    //上扭蛋
    ERROR_GA_NO_ITEM("00006", "扭蛋中的物品在item中没有，请先添加！", "扭蛋中的物品在item中没有，请先添加！"),
    WARN_GA_INVALID_ITEM_PRICE("00007", "物品在扭蛋中的价格必须高于物品买价的2倍！", "物品在扭蛋中的价格必须高于物品买价的2倍！"),
    WARN_GA_SHOP_ITEM_APPEAR("00008", "物品在兑换商店中出现了！", "物品在兑换商店中出现了！"),

    //兑换商店
    WARN_SHOP_ITEM_EMPTY("00009", "兑换商店中的商品不存在！", "兑换商店中的商品不存在！"),
    ERROR_SHOP_CHANGEABLE("00011", "商品积分要互相能兑换！", "商品积分要互相能兑换！"),
    ERROR_SHOP_SCORE_CHANGEABLE("00012", "商品积分可兑换但兑换量小于1！", "商品积分可兑换但兑换量小于1"),
    WARN_SHOP_CHANGEABLE_DISCOUNT("00013", "商品积分兑换折损率>30%！", "商品积分兑换折损率>30%"),
    WARN_SHOP_BUY_PRICE_5_LESS("00014", "兑换积分小于购买价格的5倍！", "兑换积分小于购买价格的5倍！"),

    //魔法卡
    WARN_MAGIC_PRICE_LESS("00015", "魔法卡中的商品价格不得少于doll_item商品价格两倍！", "魔法卡中的商品价格不得少于doll_item商品价格两倍"),
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
