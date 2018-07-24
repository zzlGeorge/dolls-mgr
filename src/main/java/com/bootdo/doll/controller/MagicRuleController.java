package com.bootdo.doll.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.service.MagicBoxService;
import com.bootdo.doll.service.bo.MagicBoxBO;
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

import com.bootdo.doll.domain.MagicRuleDO;
import com.bootdo.doll.service.MagicRuleService;
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
@RequestMapping("/doll/magicRule")
public class MagicRuleController {
    @Autowired
    private MagicRuleService magicRuleService;

    @Autowired
    private MagicBoxService magicBoxService;

    @GetMapping()
    @RequiresPermissions("doll:magicRule:magicRule")
    String MagicRule() {
        return "doll/magicRule/magicRule";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("doll:magicRule:magicRule")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MagicRuleDO> magicRuleList = magicRuleService.list(query);
        int total = magicRuleService.count(query);
        PageUtils pageUtils = new PageUtils(magicRuleList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/listMagicBox")
    @RequiresPermissions("doll:magicItem:magicItem")
    public PageUtils listMagicBox(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MagicBoxBO> magicItemList = magicRuleService.listMagicBox(query);
        int total = magicBoxService.count(query);
        PageUtils pageUtils = new PageUtils(magicItemList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("doll:magicRule:add")
    String add() {
        return "doll/magicRule/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("doll:magicRule:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        MagicRuleDO magicRule = magicRuleService.get(id);
        model.addAttribute("magicRule", magicRule);
        return "doll/magicRule/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("doll:magicRule:add")
    public R save(@Valid MagicRuleDO magicRule, BindingResult bindingResult) {

        //校验错误搜集
        List<String> errorList = CommonValidate.beanValidate(new ArrayList<>(), bindingResult);
        if (errorList.size() > 0) {
            return R.error(406, "校验失败", errorList);
        }

        if (magicRuleService.save(magicRule) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("doll:magicRule:edit")
    public R update(MagicRuleDO magicRule) {
        magicRuleService.update(magicRule);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("doll:magicRule:remove")
    public R remove(Long id) {
        if (magicRuleService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("doll:magicRule:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        magicRuleService.batchRemove(ids);
        return R.ok();
    }

}
