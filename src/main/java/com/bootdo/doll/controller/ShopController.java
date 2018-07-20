package com.bootdo.doll.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.service.bo.ItemShopBO;
import com.bootdo.doll.validate.CommonValidate;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.doll.domain.ShopDO;
import com.bootdo.doll.service.ShopService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.validation.Valid;

/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-20 14:36:47
 */

@Controller
@RequestMapping("/doll/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping()
    @RequiresPermissions("doll:shop:shop")
    String Shop() {
        return "doll/shop/shop";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("doll:shop:shop")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ShopDO> shopList = shopService.list(query);
        int total = shopService.count(query);
        PageUtils pageUtils = new PageUtils(shopList, total);
        return pageUtils;
    }

    /**
     * 列出商店和商品信息
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/listShopItem")
    @RequiresPermissions("doll:shop:shop")
    public PageUtils listShopItem(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ItemShopBO> shopList = shopService.listShopItem(query);
        int total = shopService.count(query);
        PageUtils pageUtils = new PageUtils(shopList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("doll:shop:add")
    String add() {
        return "doll/shop/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("doll:shop:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ShopDO shop = shopService.get(id);
        model.addAttribute("shop", shop);
        return "doll/shop/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("doll:shop:add")
    public R save(@Valid ShopDO shop, BindingResult bindingResult) {

        List<String> errorList = CommonValidate.beanValidate(new ArrayList<>(), bindingResult);
        if (errorList.size() > 0) {
            return R.error(406, "校验失败", errorList);
        }

        if (shopService.save(shop) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("doll:shop:edit")
    public R update(ShopDO shop) {
        shopService.update(shop);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("doll:shop:remove")
    public R remove(Long id) {
        if (shopService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("doll:shop:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        shopService.batchRemove(ids);
        return R.ok();
    }

}
