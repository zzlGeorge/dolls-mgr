package com.bootdo.doll.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bootdo.common.utils.StringUtils;
import com.bootdo.doll.constant.DollReturnCode;
import com.bootdo.doll.controller.cond.ItemMachineCond;
import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.service.bo.MachineBO;
import com.bootdo.doll.validate.CommonValidate;
import org.activiti.bpmn.converter.parser.ItemDefinitionParser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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

    @ResponseBody
    @GetMapping("/listMachineItem")
    @RequiresPermissions("doll:machine:machine")
    public PageUtils listMachineItem(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MachineBO> listMachineItem = machineService.listMachineItem(query);
        int total = machineService.count(query);
        PageUtils pageUtils = new PageUtils(listMachineItem, total);
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
    public R save(@Valid MachineDO machine, BindingResult bindingResult) {
        List<String> errorList = new LinkedList<>();
        if (bindingResult.hasErrors()) {//校验参数错误信息搜集
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorList.add(error.getDefaultMessage());
            }
        }

        if (errorList.size() > 0) {
            return R.error(406, "校验失败", errorList);
        }

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
    public R saveNew(@Valid ItemMachineCond cond, BindingResult bindingResult) {

        //biz_id 必须在 item_weight 表里面有 item_id 对应

        ItemDO item = getItemDO(cond);
        MachineDO machine = getMachineDO(cond);
        List<String> errorList = CommonValidate.itemValidate(item, bindingResult);

        if (errorList.size() > 0) {
            return R.error(406, "校验失败", errorList);
        }

        if (machineService.saveNew(machine, item) > 0) {
            return R.ok();
        }
        return R.error();
    }

    private ItemDO getItemDO(ItemMachineCond cond){
        ItemDO itemDO = new ItemDO();

        itemDO.setIntro(cond.getIntro());
        itemDO.setTakeCry(cond.getTakeCry());
        itemDO.setImgDetail(cond.getImgDetail());
        itemDO.setImg(cond.getImg());
        itemDO.setBizId(cond.getBizId());
        itemDO.setBizType(cond.getBizType());
        itemDO.setBuyPrice(cond.getBuyPrice());
        itemDO.setChangeCry(cond.getChangeCry());
        itemDO.setChangeText(cond.getChangeText());
        itemDO.setName(cond.getName());
        itemDO.setPackageName(cond.getPackageName());
        itemDO.setPk(cond.getPk());
        itemDO.setRewardPercent(cond.getRewardPercent());
        itemDO.setTag(cond.getTag());
        itemDO.setVipLimit(cond.getVipLimit());
        itemDO.setWeight(cond.getWeight());
        itemDO.setPrice(cond.getPrice());
        itemDO.setItemImg(cond.getItemImg());
        itemDO.setItemType(cond.getItemType());

        return itemDO;
    }

    private MachineDO getMachineDO(ItemMachineCond cond){
        MachineDO machineDO = new MachineDO();

        machineDO.setChatRoom(cond.getChatRoom());
        machineDO.setItemId(cond.getItemId());
        machineDO.setMachineAddress(cond.getMachineAddress());
        machineDO.setMachineId(cond.getMachineId());
        machineDO.setMachineMac(cond.getMachineMac());
        machineDO.setMachineStatus(cond.getMachineStatus());
        machineDO.setMainCamera(cond.getMainCamera());
        machineDO.setSubCamera(cond.getSubCamera());

        return machineDO;
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
