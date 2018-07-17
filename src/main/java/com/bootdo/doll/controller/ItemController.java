package com.bootdo.doll.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.service.ItemService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-17 15:17:23
 */

@Controller
@RequestMapping("/doll/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping()
    @RequiresPermissions("doll:item:item")
    String Item() {
        return "doll/item/item";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("doll:item:item")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ItemDO> itemList = itemService.list(query);
        int total = itemService.count(query);
        PageUtils pageUtils = new PageUtils(itemList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("doll:item:add")
    String add() {
        return "doll/item/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("doll:item:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ItemDO item = itemService.get(id);
        model.addAttribute("item", item);
        return "doll/item/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("doll:item:add")
    public R save(ItemDO item) {
        if (itemService.save(item) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("doll:item:edit")
    public R update(ItemDO item) {
        itemService.update(item);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("doll:item:remove")
    public R remove(Long id) {
        if (itemService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("doll:item:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        itemService.batchRemove(ids);
        return R.ok();
    }

}
