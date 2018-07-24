package com.bootdo.doll.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.bootdo.doll.domain.MagicBoxDO;
import com.bootdo.doll.service.MagicBoxService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.validation.Valid;

/**
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-23 16:42:26
 */

@Controller
@RequestMapping("/doll/magicBox")
public class MagicBoxController {
    @Autowired
    private MagicBoxService magicBoxService;

    @GetMapping()
    @RequiresPermissions("doll:magicBox:magicBox")
    String MagicBox() {
        return "doll/magicBox/magicBox";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("doll:magicBox:magicBox")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MagicBoxDO> magicBoxList = magicBoxService.list(query);
        int total = magicBoxService.count(query);
        PageUtils pageUtils = new PageUtils(magicBoxList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/listAll")
    @RequiresPermissions("doll:magicBox:magicBox")
    public PageUtils listAll(@RequestParam Map<String, Object> params) {
        List<MagicBoxDO> magicBoxList = magicBoxService.list(params);
        PageUtils pageUtils = new PageUtils(magicBoxList, 0);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("doll:magicBox:add")
    String add() {
        return "doll/magicBox/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("doll:magicBox:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        MagicBoxDO magicBox = magicBoxService.get(id);
        model.addAttribute("magicBox", magicBox);
        return "doll/magicBox/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("doll:magicBox:add")
    public R save(@Valid MagicBoxDO magicBox, BindingResult bindingResult) {

        //校验错误搜集
        List<String> errorList = CommonValidate.beanValidate(new ArrayList<>(), bindingResult);
        if (errorList.size() > 0) {
            return R.error(406, "校验失败", errorList);
        }

        if (magicBoxService.save(magicBox) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("doll:magicBox:edit")
    public R update(MagicBoxDO magicBox) {
        magicBoxService.update(magicBox);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("doll:magicBox:remove")
    public R remove(Long id) {
        if (magicBoxService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("doll:magicBox:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        magicBoxService.batchRemove(ids);
        return R.ok();
    }

}
