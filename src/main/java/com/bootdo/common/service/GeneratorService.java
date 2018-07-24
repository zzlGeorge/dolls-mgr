
package com.bootdo.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author mading
 * @Time 2018年7月23日16:03:09
 * @description
 */
@Service
public interface GeneratorService {
    List<Map<String, Object>> list();


    /**
     * 生成代码至zip文件中，并返回二进制数据
     *
     * @param tableNames
     * @return
     */
    byte[] generatorZipCode(String[] tableNames);

    /**
     * 生成代码至工程文件中
     *
     * @param tableNames
     * @param packageName
     * @return
     */
    boolean generatorProjectCode(String[] tableNames, String packageName);
}
