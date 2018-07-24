package com.bootdo.common.utils;


import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.ColumnDO;
import com.bootdo.common.domain.TableDO;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器   工具类
 */
public class GenUtils {

    private static Logger logger = Logger.getLogger(GenUtils.class);

    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("templates/common/generator/domain.java.vm");
        templates.add("templates/common/generator/Dao.java.vm");
        //templates.add("templates/common/generator/Mapper.java.vm");
        templates.add("templates/common/generator/Mapper.xml.vm");
        templates.add("templates/common/generator/Service.java.vm");
        templates.add("templates/common/generator/ServiceImpl.java.vm");
        templates.add("templates/common/generator/Controller.java.vm");
        templates.add("templates/common/generator/list.html.vm");
        templates.add("templates/common/generator/add.html.vm");
        templates.add("templates/common/generator/edit.html.vm");
        templates.add("templates/common/generator/list.js.vm");
        templates.add("templates/common/generator/add.js.vm");
        templates.add("templates/common/generator/edit.js.vm");
        //templates.add("templates/common/generator/menu.sql.vm");
        return templates;
    }

    /**
     * 生成的代码放入zip中
     *
     * @param table
     * @param columns
     * @param zip
     */
    public static void generatorCodeToZip(Map<String, String> table,
                                          List<Map<String, String>> columns, ZipOutputStream zip) {
        //配置信息
        Configuration config = getConfig();

        TableDO tableDO = getTableDO(table, config, columns);

        VelocityContext context = getContext(tableDO, config);

        for (String template : getTemplates()) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);

            try {
                //添加到zip
                zip.putNextEntry(new ZipEntry(getFileName(template, tableDO.getClassname(), tableDO.getClassName(), config.getString("package").substring(config.getString("package").lastIndexOf(".") + 1))));
                IOUtils.write(sw.toString(), zip, "UTF-8");
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                throw new BDException("渲染模板失败，表名：" + tableDO.getTableName(), e);
            }
        }

    }

    /**
     * 生成的代码放入项目工程文件中
     *
     * @param table
     * @param columns
     */
    public static boolean generatorCodeToProject(Map<String, String> table, List<Map<String, String>> columns, String packageName) {
        //配置信息
        Configuration config = getConfig();

        TableDO tableDO = getTableDO(table, config, columns);

        VelocityContext context = getContext(tableDO, config);

        for (String template : getTemplates()) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);

            try {
                String fileName = getFileName(template, tableDO.getClassname(), tableDO.getClassName(), packageName);
                FileUtil.createFile(fileName);
                if (StringUtils.isNotBlank(fileName)) {
                    File file = new File(fileName);
                    FileOutputStream fos = new FileOutputStream(file);
                    IOUtils.write(sw.toString(), fos, "UTF-8");
                    IOUtils.closeQuietly(sw);
                    fos.close();
                } else {
                    logger.warn("未获取文件路径！");
                }
            } catch (IOException e) {
                throw new BDException("渲染模板失败，表名：" + tableDO.getTableName(), e);
            }
        }

        return true;
    }


    /**
     * 获取表对象属性数据
     *
     * @param table
     * @param config
     * @param columns
     * @return
     */
    private static TableDO getTableDO(Map<String, String> table, Configuration config,
                                      List<Map<String, String>> columns) {
        //表信息
        TableDO tableDO = new TableDO();
        tableDO.setTableName(table.get("tableName"));
        tableDO.setComments(table.get("tableComment"));
        //表名转换成Java类名
        String className = tableToJava(tableDO.getTableName(), config.getString("tablePrefix"), config.getString("autoRemovePre"));
        tableDO.setClassName(className);
        tableDO.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnDO> columsList = new ArrayList<>();
        for (Map<String, String> column : columns) {
            ColumnDO columnDO = new ColumnDO();
            columnDO.setColumnName(column.get("columnName"));
            columnDO.setDataType(column.get("dataType"));
            columnDO.setComments(column.get("columnComment"));
            columnDO.setExtra(column.get("extra"));

            //列名转换成Java属性名
            String attrName = columnToJava(columnDO.getColumnName());
            columnDO.setAttrName(attrName);
            columnDO.setAttrname(StringUtils.uncapitalize(attrName));

            //列的数据类型，转换成Java类型
            String attrType = config.getString(columnDO.getDataType(), "unknowType");
            columnDO.setAttrType(attrType);

            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableDO.getPk() == null) {
                tableDO.setPk(columnDO);
            }

            columsList.add(columnDO);
        }
        tableDO.setColumns(columsList);

        //没主键，则第一个字段为主键
        if (tableDO.getPk() == null) {
            tableDO.setPk(tableDO.getColumns().get(0));
        }

        return tableDO;
    }

    /**
     * 获取模板文件上下文
     *
     * @param tableDO
     * @param config
     * @return
     */
    private static VelocityContext getContext(TableDO tableDO, Configuration config) {
        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        //封装模板数据
        Map<String, Object> map = new HashMap<>(16);
        map.put("tableName", tableDO.getTableName());
        map.put("comments", tableDO.getComments());
        map.put("pk", tableDO.getPk());
        map.put("className", tableDO.getClassName());
        map.put("classname", tableDO.getClassname());
        map.put("pathName", config.getString("package").substring(config.getString("package").lastIndexOf(".") + 1));
        map.put("columns", tableDO.getColumns());
        map.put("package", config.getString("package"));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));

        return new VelocityContext(map);
    }

    /**
     * 列名转换成Java属性名
     */
    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName, String tablePrefix, String autoRemovePre) {
        if (Constant.AUTO_REOMVE_PRE.equals(autoRemovePre)) {
            tableName = tableName.substring(tableName.indexOf("_") + 1);
        }
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }

        return columnToJava(tableName);
    }

    /**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new BDException("获取配置文件失败，", e);
        }
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, String classname, String className, String packageName) {
        String packagePath = "src" + File.separator + "main" + File.separator + "java" + File.separator;

        String moduleName = packageName.substring(packageName.lastIndexOf(".") + 1);

        //String modulesname=config.getString("packageName");
        if (StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator;
        }

        if (template.contains("domain.java.vm")) {
            return packagePath + "domain" + File.separator + className + "DO.java";
        }

        if (template.contains("Dao.java.vm")) {
            return packagePath + "dao" + File.separator + className + "Dao.java";
        }

//		if(template.contains("Mapper.java.vm")){
//			return packagePath + "dao" + File.separator + className + "Mapper.java";
//		}

        if (template.contains("Service.java.vm")) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }

        if (template.contains("ServiceImpl.java.vm")) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }

        if (template.contains("Controller.java.vm")) {
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }

        if (template.contains("Mapper.xml.vm")) {
            return "src" + File.separator + "main" + File.separator + "resources" + File.separator + "doll.mybatis" + File.separator + className + "Mapper.xml";
        }

        if (template.contains("list.html.vm")) {
            return "src" + File.separator + "main" + File.separator + "resources" + File.separator + "templates" + File.separator
                    + moduleName + File.separator + classname + File.separator + classname + ".html";
            //				+ "modules" + File.separator + "generator" + File.separator + className.toLowerCase() + ".html";
        }
        if (template.contains("add.html.vm")) {
            return "src" + File.separator + "main" + File.separator + "resources" + File.separator + "templates" + File.separator
                    + moduleName + File.separator + classname + File.separator + "add.html";
        }
        if (template.contains("edit.html.vm")) {
            return "src" + File.separator + "main" + File.separator + "resources" + File.separator + "templates" + File.separator
                    + moduleName + File.separator + classname + File.separator + "edit.html";
        }

        if (template.contains("list.js.vm")) {
            return "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "js" + File.separator
                    + "appjs" + File.separator + moduleName + File.separator + classname + File.separator + classname + ".js";
            //		+ "modules" + File.separator + "generator" + File.separator + className.toLowerCase() + ".js";
        }
        if (template.contains("add.js.vm")) {
            return "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "js" + File.separator
                    + "appjs" + File.separator + moduleName + File.separator + classname + File.separator + "add.js";
        }
        if (template.contains("edit.js.vm")) {
            return "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "js" + File.separator
                    + "appjs" + File.separator + moduleName + File.separator + classname + File.separator + "edit.js";
        }

//		if(template.contains("menu.sql.vm")){
//			return className.toLowerCase() + "_menu.sql";
//		}

        return null;
    }
}
