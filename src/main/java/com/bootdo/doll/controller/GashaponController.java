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

import com.bootdo.doll.domain.GashaponDO;
import com.bootdo.doll.service.GashaponService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author mading
 * @email zhang0909990@qq.com
 * @date 2018-07-19 17:04:41
 */
 
@Controller
@RequestMapping("/doll/gashapon")
public class GashaponController {
	@Autowired
	private GashaponService gashaponService;
	
	@GetMapping()
	@RequiresPermissions("doll:gashapon:gashapon")
	String Gashapon(){
	    return "doll/gashapon/gashapon";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("doll:gashapon:gashapon")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GashaponDO> gashaponList = gashaponService.list(query);
		int total = gashaponService.count(query);
		PageUtils pageUtils = new PageUtils(gashaponList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("doll:gashapon:add")
	String add(){
	    return "doll/gashapon/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("doll:gashapon:edit")
	String edit(@PathVariable("biz_id") Long id,Model model){
		GashaponDO gashapon = gashaponService.get(id);
		model.addAttribute("gashapon", gashapon);
	    return "doll/gashapon/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("doll:gashapon:add")
	public R save( GashaponDO gashapon){
		if(gashaponService.save(gashapon)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("doll:gashapon:edit")
	public R update( GashaponDO gashapon){
		gashaponService.update(gashapon);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("doll:gashapon:remove")
	public R remove( Long id){
		if(gashaponService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("doll:gashapon:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		gashaponService.batchRemove(ids);
		return R.ok();
	}
	
}
