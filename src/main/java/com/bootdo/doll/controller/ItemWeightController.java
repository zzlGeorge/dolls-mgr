package com.bootdo.doll.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.doll.service.bo.ItemWeightBO;
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

import com.bootdo.doll.domain.ItemWeightDO;
import com.bootdo.doll.service.ItemWeightService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-18 19:37:00
 */

@Controller
@RequestMapping("/doll/itemWeight")
public class ItemWeightController {
    @Autowired
    private ItemWeightService itemWeightService;

    @GetMapping()
    @RequiresPermissions("doll:itemWeight:itemWeight")
    String ItemWeight() {
        return "doll/itemWeight/itemWeight";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("doll:itemWeight:itemWeight")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ItemWeightDO> itemWeightList = itemWeightService.list(query);
        int total = itemWeightService.count(query);
        PageUtils pageUtils = new PageUtils(itemWeightList, total);
        return pageUtils;
    }

    /**
     * 列出产品和权重数据
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/listItemWeight")
    @RequiresPermissions("doll:itemWeight:itemWeight")
    public PageUtils listItemWeight(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ItemWeightBO> itemWeightBOList = itemWeightService.queryItemAndWeight(query);
        int total = itemWeightService.count(query);
        PageUtils pageUtils = new PageUtils(itemWeightBOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("doll:itemWeight:add")
    String add() {
        return "doll/itemWeight/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("doll:itemWeight:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ItemWeightDO itemWeight = itemWeightService.get(id);
        model.addAttribute("itemWeight", itemWeight);
        return "doll/itemWeight/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("doll:itemWeight:add")
    public R save(ItemWeightDO itemWeight) {

        R result = itemWeightService.save(itemWeight, R.ok());

        if (result.get("error") == null) {
            return R.ok();
        }
        return result;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("doll:itemWeight:edit")
    public R update(ItemWeightDO itemWeight) {
        itemWeightService.update(itemWeight);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("doll:itemWeight:remove")
    public R remove(Long id) {
        if (itemWeightService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("doll:itemWeight:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        itemWeightService.batchRemove(ids);
        return R.ok();
    }

}
