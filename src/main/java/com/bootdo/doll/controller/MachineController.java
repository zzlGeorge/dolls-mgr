package com.bootdo.doll.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.doll.domain.ItemDO;
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

import com.bootdo.doll.domain.MachineDO;
import com.bootdo.doll.service.MachineService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.validation.Valid;

/**
 * 机器
 *
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-17 18:06:32
 */

@Controller
@RequestMapping("/doll/machine")
public class MachineController {
    @Autowired
    private MachineService machineService;

    @GetMapping()
    @RequiresPermissions("doll:machine:machine")
    String Machine() {
        return "doll/machine/machine";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("doll:machine:machine")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MachineDO> machineList = machineService.list(query);
        int total = machineService.count(query);
        PageUtils pageUtils = new PageUtils(machineList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("doll:machine:add")
    String add() {
        return "doll/machine/add";
    }

    @GetMapping("/addNew")
    @RequiresPermissions("doll:machine:addNew")
    String addNew() {
        return "doll/machine/addNew";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("doll:machine:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        MachineDO machine = machineService.get(id);
        model.addAttribute("machine", machine);
        return "doll/machine/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("doll:machine:add")
    public R save(MachineDO machine) {
        if (machineService.save(machine) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 上新娃娃
     *
     * @param machine
     * @return
     */
    @ResponseBody
    @PostMapping("/saveNew")
    @RequiresPermissions("doll:machine:addNew")
    public R saveNew(@Valid MachineDO machine, @Valid ItemDO item, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return R.error();
        }
//        if (machineService.saveNew(machine,item) > 0) {
//            return R.ok();
//        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("doll:machine:edit")
    public R update(MachineDO machine) {
        machineService.update(machine);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("doll:machine:remove")
    public R remove(Long id) {
        if (machineService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("doll:machine:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        machineService.batchRemove(ids);
        return R.ok();
    }

}
