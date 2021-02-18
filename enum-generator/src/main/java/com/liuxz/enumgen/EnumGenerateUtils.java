package com.liuxz.enumgen;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述：枚举类代码生成工具
 * Created by Ay on 2017/5/5.
 */
public class EnumGenerateUtils {

    //枚举需要生成到那个包下面
    private final String packageName = "com.liuxz.enumgen";
    //枚举分类的code 和 字典表中的 categoryCode必须一致
    private final String enumCategoryCode = "TM_XXXX_XXXX_XXXX";
    private final String enumCategoryName = "项目管理-管控模式-枚举";
    //枚举类名称
    private final String enumClassName = "Color";
    //枚举类生成后类上的注解
    private final String enumAnnotation = "颜色";
    //这里比较重要
    private final String[][] ENUM_INFO = {
            {"BLUE", "蓝色"},
            {"YELLOW", "黄色"},
            {"BLACK", "黑色"}
    };
    //类上的作者
    private final String AUTHOR = "Ay";
    //类上的日期
    private final String CURRENT_DATE = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    public static void main(String[] args) throws Exception {
        EnumGenerateUtils enumGenerateUtils = new EnumGenerateUtils();
        //生成枚举类java文件
        enumGenerateUtils.generateEnumClassFile();
        //生成sql脚本文件
        enumGenerateUtils.generateEnumSqlFile();
    }


    private void generateEnumSqlFile() throws Exception {
        final String suffix = ".sql";
        final String path = "C://" + CURRENT_DATE + suffix;
        final String templateName = "EnumSQL.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        List<EnumInfoDefinition> enumInfoDefinitionList = new ArrayList<>();
        EnumInfoDefinition enumInfoDefinition = null;
        for (int i = 0; i < ENUM_INFO.length; i++) {
            enumInfoDefinition = new EnumInfoDefinition();
            enumInfoDefinition.setEnumUuid(EnumGenerateUtils.generateUUID());
            enumInfoDefinition.setEnumCode(ENUM_INFO[i][0]);
            enumInfoDefinition.setEnumName(ENUM_INFO[i][1]);
            enumInfoDefinition.setEnumCategoryCode(enumCategoryCode);
            enumInfoDefinition.setEnumNumber(i + 1 + "");
            enumInfoDefinition.setEnumSortOrder(i + 1 + "");
            enumInfoDefinitionList.add(enumInfoDefinition);
        }
        EnumDictCategoryDefinition dictCategory = new EnumDictCategoryDefinition();
        dictCategory.setEnumUuid(EnumGenerateUtils.generateUUID());
        dictCategory.setEnumCategoryCode(enumCategoryCode);
        dictCategory.setEnumCategoryName(enumCategoryName);
        dataMap.put("enum_dict_catagory", dictCategory);
        dataMap.put("enum_list", enumInfoDefinitionList);
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generateEnumClassFile() throws Exception {
        final String suffix = "Enum.java";
        final String path = "C://" + enumClassName + suffix;
        final String templateName = "EnumClass.ftl";

        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        List<EnumInfoDefinition> enumInfoDefinitionList = new ArrayList<>();
        EnumInfoDefinition enumInfoDefinition = null;
        for (int i = 0; i < ENUM_INFO.length; i++) {
            enumInfoDefinition = new EnumInfoDefinition();
            enumInfoDefinition.setEnumUuid(EnumGenerateUtils.generateUUID());
            enumInfoDefinition.setEnumCode(ENUM_INFO[i][0]);
            enumInfoDefinition.setEnumName(ENUM_INFO[i][1]);
            enumInfoDefinition.setEnumNumber(i + 1 + "");
            enumInfoDefinition.setEnumSortOrder(i + 1 + "");
            enumInfoDefinition.setEnumCategoryCode(enumCategoryCode);
            enumInfoDefinitionList.add(enumInfoDefinition);
        }
        dataMap.put("enum_list", enumInfoDefinitionList);
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generateFileByTemplate(final String templateName, File file, Map<String, Object> dataMap) throws Exception {
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("author", AUTHOR);
        dataMap.put("date", CURRENT_DATE);
        dataMap.put("package_name", packageName);
        dataMap.put("enum_annotation", enumAnnotation);
        dataMap.put("enum_class_name", enumClassName);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

