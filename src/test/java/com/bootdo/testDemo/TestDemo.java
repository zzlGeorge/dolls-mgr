package com.bootdo.testDemo;

import com.bootdo.common.service.GeneratorService;
import com.bootdo.common.utils.Query;
import com.bootdo.doll.dao.MachineDao;
import com.bootdo.doll.dao.ProbablityDao;
import com.bootdo.doll.domain.ProbablityDO;
import com.bootdo.doll.service.bo.GashaponItemPbBO;
import com.bootdo.doll.service.bo.ItemProbBO;
import com.bootdo.doll.service.bo.MachineBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {

    @Autowired
    private MachineDao machineDao;

    @Autowired
    private ProbablityDao probablityDao;

    @Autowired
    private GeneratorService generatorService;

    @Test
    public void common() {
        Map<String, Object> param = new HashMap<>();
        param.put("offset", 0);
        param.put("limit", 10);
        Query query = new Query(param);
//        List<MachineBO> machineBOS = machineDao.queryMachineItem(query);
//        List<GashaponItemPbBO> gashaponItemPbBOS = probablityDao.listGashaponItemPb(query);

        List<ItemProbBO> itemProbBOList = probablityDao.listItemProb(query);

        System.out.println();
    }

    /**
     * 代码生成
     */
    @Test
    public void testGenerate() {
        generatorService.generatorProjectCode(new String[]{"doll_magic_box", "doll_magic_item", "doll_magic_rule"}, "com.bootdo.doll");
        System.out.println();
    }

    public static void main(String[] args) {
        String packageName = "com.bootdo.doll";
        String moduleName = packageName.substring(packageName.lastIndexOf(".") + 1);
        System.out.println(moduleName);
    }
}
