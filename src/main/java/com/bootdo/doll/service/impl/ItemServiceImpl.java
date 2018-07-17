package com.bootdo.doll.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.ItemDao;
import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.service.ItemService;



@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;
	
	@Override
	public ItemDO get(Long id){
		return itemDao.get(id);
	}
	
	@Override
	public List<ItemDO> list(Map<String, Object> map){
		return itemDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return itemDao.count(map);
	}
	
	@Override
	public int save(ItemDO item){
		return itemDao.save(item);
	}
	
	@Override
	public int update(ItemDO item){
		return itemDao.update(item);
	}
	
	@Override
	public int remove(Long id){
		return itemDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return itemDao.batchRemove(ids);
	}
	
}
