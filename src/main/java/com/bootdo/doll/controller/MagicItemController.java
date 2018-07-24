package com.bootdo.doll.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.service.MagicBoxService;
import com.bootdo.doll.service.bo.MagicBoxBO;
import com.bootdo.doll.service.bo.MagicItemBO;
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

import com.bootdo.doll.domain.MagicItemDO;
import com.bootdo.doll.service.MagicItemService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.validation.Valid;

/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-23 16:42:27
 */

@Controller
@RequestMapping("/doll/magicItem")
public class MagicItemController {
    @Autowired
    private MagicItemService magicItemService;

    @Autowired
    private MagicBoxService magicBoxService;

    @GetMapping()
    @RequiresPermissions("doll:magicItem:magicItem")
    String MagicItem() {
        return "doll/magicItem/magicItem";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("doll:magicItem:magicItem")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MagicItemDO> magicItemList = magicItemService.list(query);
        int total = magicItemService.count(query);
        PageUtils pageUtils = new PageUtils(magicItemList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/listMagicBoxInfo")
    @RequiresPermissions("doll:magicItem:magicItem")
    public PageUtils listMagicBoxInfo(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MagicBoxBO> magicItemList = magicItemService.listMagicBoxInfo(query);
        int total = magicBoxService.count(query);
        PageUtils pageUtils = new PageUtils(magicItemList, total);
        return pageUtils;
    }

    /**
     * 列出魔法盒与商品的关联信息
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/listMagicItems")
    @RequiresPermissions("doll:magicItem:magicItem")
    public PageUtils listMagicItems(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MagicItemBO> magicItemList = magicItemService.listMagicItems(query);
        int total = magicItemService.count(query);
        PageUtils pageUtils = new PageUtils(magicItemList, total);
        return pageUtils;
    }


    @GetMapping("/add")
    @RequiresPermissions("doll:magicItem:add")
    String add() {
        return "doll/magicItem/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("doll:magicItem:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        MagicItemDO magicItem = magicItemService.get(id);
        model.addAttribute("magicItem", magicItem);
        return "doll/magicItem/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("doll:magicItem:add")
    public R save(@Valid MagicItemDO magicItem, BindingResult bindingResult) {

        //校验错误搜集
        List<String> errorList = CommonValidate.beanValidate(new ArrayList<>(), bindingResult);
        if (errorList.size() > 0) {
            return R.error(406, "校验失败", errorList);
        }

        if (magicItemService.save(magicItem) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("doll:magicItem:edit")
    public R update(MagicItemDO magicItem) {
        magicItemService.update(magicItem);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("doll:magicItem:remove")
    public R remove(Long id) {
        if (magicItemService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("doll:magicItem:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        magicItemService.batchRemove(ids);
        return R.ok();
    }

}
