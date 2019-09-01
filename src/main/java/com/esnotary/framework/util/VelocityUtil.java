package com.esnotary.framework.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/25 11:12
 * @Description:
 */
public class VelocityUtil {

    static {
        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
    }

    public static void outFile(String template, Map<String,Object> map, OutputStream outputStream){
        //渲染模板
        try(Writer sw = new OutputStreamWriter(outputStream);) {
            Template tpl = Velocity.getTemplate(template, "UTF-8" );
            VelocityContext context = new VelocityContext(map);
            tpl.merge(context, sw);
            sw.close();
        }catch (IOException e){
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    public static String outFile(String template, Map<String,Object> map){
        //渲染模板
        try{
            Writer sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8" );
            VelocityContext context = new VelocityContext(map);
            tpl.merge(context, sw);
            sw.close();
            return sw.toString();
        }catch (IOException e){
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}
