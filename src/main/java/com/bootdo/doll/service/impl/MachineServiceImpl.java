package com.bootdo.doll.service.impl;

import com.bootdo.common.utils.Query;
import com.bootdo.doll.dao.ItemDao;
import com.bootdo.doll.domain.ItemDO;
import com.bootdo.doll.service.ItemService;
import com.bootdo.doll.service.bo.MachineBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.MachineDao;
import com.bootdo.doll.domain.MachineDO;
import com.bootdo.doll.service.MachineService;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MachineServiceImpl implements MachineService {
    @Autowired
    private MachineDao machineDao;
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ItemService itemService;

    @Override
    public MachineDO get(Long id) {
        return machineDao.get(id);
    }

    @Override
    public List<MachineDO> list(Map<String, Object> map) {
        return machineDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return machineDao.count(map);
    }

    @Override
    public int save(MachineDO machine) {
        machine.setGmtModify(new Date());
        machine.setGmtCreate(new Date());
        return machineDao.save(machine);
    }

    @Override
    public int update(MachineDO machine) {
        return machineDao.update(machine);
    }

    @Override
    public int remove(Long id) {
        return machineDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return machineDao.batchRemove(ids);
    }

    @Override
    public int saveNew(MachineDO machine, ItemDO item) {
        int machineRs = save(machine);
        int itemRs = itemService.save(item);
        return machineRs > 0 && itemRs > 0 ? 1 : 0;
    }

    @Override
    public List<MachineBO> listMachineItem(Query query) {
        return machineDao.queryMachineItem(query);
    }

}
