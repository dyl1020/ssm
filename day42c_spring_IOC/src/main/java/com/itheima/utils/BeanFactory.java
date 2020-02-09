package com.itheima.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ssm
 * @ClassName BeanFactory
 * @description: 创建对象工厂的工具类
 * @author: dyl
 * @create: 2020-01-08 23:21
 **/

public class BeanFactory {
    //创建map
    public static Map<String, Object> beanMap = new HashMap<String, Object>();

    //程序初始化的时候, 把xml解析好 反射创建好 存到容器【map key是id, value是对应的对象】里面
    static {
        InputStream is = null;
            try {
                //1.创建SAXReader对象
                SAXReader saxReader = new SAXReader();
                // 2.读取xml 获得document对象
                is = BeanFactory.class.getClassLoader().getResourceAsStream("applicationContext.xml");
                Document read = saxReader.read(is);
                //获得所有的bean标签
                List <Element> listelem = read.selectNodes("//bean");
                //遍历说有bean标签
                for (Element element : listelem) {
                    //获得bean标签的id和class属性值
                    String id = element.attributeValue("id");
                    String className = element.attributeValue("class");
                    //根据class属性值(类的权限定名)反射创建对象存在map中 id作为map的key,class属性值作为value
                    Object obj =Class.forName(className).newInstance();
                    beanMap.put(id,obj);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //关流
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //根据id获得相应的bean对象
    public static Object getBean(String id ){
        return beanMap.get(id);
    }
    }
