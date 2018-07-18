package com.bootdo.doll.validate;

import com.bootdo.common.utils.StringUtils;
import com.bootdo.doll.constant.DollReturnCode;
import com.bootdo.doll.domain.ItemDO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.LinkedList;
import java.util.List;

/**
 * @author mading
 * @desc 通用验证
 * @date 2018/7/18
 **/
public class CommonValidate {

    /**
     * 校验doll_item数据
     *
     * @param item
     * @param bindingResult
     * @return errorList
     */
    public static List<String> itemValidate(ItemDO item, BindingResult bindingResult) {
        List<String> errorList = new LinkedList<>();

        if (bindingResult.hasErrors()) {//校验参数错误信息搜集
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorList.add(error.getDefaultMessage());
            }
        }

        //img，item_img 不能重复
        if (StringUtils.equals(item.getImg(), item.getItemImg())) {
            errorList.add(DollReturnCode.WARN_IMG_ITEMIMG_NOT_REPEAT.getDescription());
        }
        //price 必须大于 take_cry
        if (item.getPrice() != null && item.getTakeCry() != null && item.getPrice() <= item.getTakeCry()) {
            errorList.add(DollReturnCode.WARN_TAKECRY_GREATER_THAN_PRICE.getDescription());
        }

        //buy_price > 10的 必须有 vip_limit
        if (item.getBuyPrice() != null && item.getBuyPrice() > 10 && item.getVipLimit() == null) {
            errorList.add(DollReturnCode.WARN_VIP_LIMIT_MUST_EXIST.getDescription());
        }

        return errorList;
    }

}
