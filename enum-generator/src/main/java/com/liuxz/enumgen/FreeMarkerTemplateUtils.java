package com.liuxz.enumgen;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.IOException;

public class FreeMarkerTemplateUtils {
    public static Template getTemplate(String templateName) {
        try {
            //通过Freemarker的Configuration读取相应的ftl
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);//这里是对应的你使用jar包的版本号：<version>2.3.23</version>
            // configuration.setDirectoryForTemplateLoading(new File("/ftl")); //如果是maven项目可以使用这种方式
            // configuration.setDirectoryForTemplateLoading(new File("C:\\projects\\liuxz\\easy-generator\\enum-generator\\src\\main\\java\\ftl")); //如果是maven项目可以使用这种方式
            //第二个参数 为你对应存放.ftl文件的包名
            // configuration.setClassForTemplateLoading(this.getClass(), "/ftl");
            Template template = configuration.getTemplate(templateName);
            return template;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
