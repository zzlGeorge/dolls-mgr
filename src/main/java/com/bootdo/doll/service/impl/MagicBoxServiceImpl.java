package com.bootdo.doll.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.doll.dao.MagicBoxDao;
import com.bootdo.doll.domain.MagicBoxDO;
import com.bootdo.doll.service.MagicBoxService;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;


@Service
@Transactional
public class MagicBoxServiceImpl implements MagicBoxService {
    @Autowired
    private MagicBoxDao magicBoxDao;

    @Override
    public MagicBoxDO get(Long id) {
        return magicBoxDao.get(id);
    }

    @Override
    public List<MagicBoxDO> list(Map<String, Object> map) {
        return magicBoxDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return magicBoxDao.count(map);
    }

    @Override
    public int save(MagicBoxDO magicBox) {
        if (StringUtils.isBlank(magicBox.getName())) {
            magicBox.setName("敬请期待");
        }

        if (StringUtils.isBlank(magicBox.getPrice())) {
            magicBox.setPrice("999");
        }

        magicBox.setGmtCreate(new Date());
        magicBox.setGmtModify(new Date());
        return magicBoxDao.save(magicBox);
    }

    @Override
    public int update(MagicBoxDO magicBox) {
        magicBox.setGmtModify(new Date());
        return magicBoxDao.update(magicBox);
    }

    @Override
    public int remove(Long id) {
        return magicBoxDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return magicBoxDao.batchRemove(ids);
    }

}
