package com.bootdo.doll.service.impl;

import com.bootdo.doll.service.bo.MagicBoxBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.MagicRuleDao;
import com.bootdo.doll.domain.MagicRuleDO;
import com.bootdo.doll.service.MagicRuleService;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MagicRuleServiceImpl implements MagicRuleService {
    @Autowired
    private MagicRuleDao magicRuleDao;

    @Override
    public MagicRuleDO get(Long id) {
        return magicRuleDao.get(id);
    }

    @Override
    public List<MagicRuleDO> list(Map<String, Object> map) {
        return magicRuleDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return magicRuleDao.count(map);
    }

    @Override
    public int save(MagicRuleDO magicRule) {

        magicRule.setGmtModify(new Date());
        magicRule.setGmtCreate(new Date());
        return magicRuleDao.save(magicRule);
    }

    @Override
    public int update(MagicRuleDO magicRule) {

        magicRule.setGmtModify(new Date());
        return magicRuleDao.update(magicRule);
    }

    @Override
    public int remove(Long id) {
        return magicRuleDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return magicRuleDao.batchRemove(ids);
    }


    @Override
    public List<MagicBoxBO> listMagicBox(Map<String, Object> map) {
        return magicRuleDao.listMagicBox(map);
    }
}
