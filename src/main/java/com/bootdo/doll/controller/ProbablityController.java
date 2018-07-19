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

import com.bootdo.doll.domain.ProbablityDO;
import com.bootdo.doll.service.ProbablityService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 随机概率表
 *
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-19 17:46:25
 */

@Controller
@RequestMapping("/doll/probablity")
public class ProbablityController {
    @Autowired
    private ProbablityService probablityService;

    @GetMapping()
    @RequiresPermissions("doll:probablity:probablity")
    String Probablity() {
        return "doll/probablity/probablity";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("doll:probablity:probablity")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ProbablityDO> probablityList = probablityService.list(query);
        int total = probablityService.count(query);
        PageUtils pageUtils = new PageUtils(probablityList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("doll:probablity:add")
    String add() {
        return "doll/probablity/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("doll:probablity:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ProbablityDO probablity = probablityService.get(id);
        model.addAttribute("probablity", probablity);
        return "doll/probablity/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("doll:probablity:add")
    public R save(ProbablityDO probablity) {
        if (probablityService.save(probablity) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("doll:probablity:edit")
    public R update(ProbablityDO probablity) {
        probablityService.update(probablity);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("doll:probablity:remove")
    public R remove(Long id) {
        if (probablityService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("doll:probablity:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        probablityService.batchRemove(ids);
        return R.ok();
    }

}
