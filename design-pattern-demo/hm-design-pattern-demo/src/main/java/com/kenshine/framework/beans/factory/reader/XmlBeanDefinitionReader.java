package com.kenshine.framework.beans.factory.reader;

import com.kenshine.framework.beans.BeanDefinition;
import com.kenshine.framework.beans.MutablePropertyValues;
import com.kenshine.framework.beans.PropertyValue;
import com.kenshine.framework.beans.factory.registry.BeanDefinitionRegistry;
import com.kenshine.framework.beans.factory.registry.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/23 23:36
 * @description：解析Xml文件加载bean对象
 * @modified By：
 * @version: $
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader{
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
        this.registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        /** 获取路径下配置文件*/
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(configLocation);
        /** 通过dom4j操作xml, 进行xml文件解析*/
        SAXReader reader = new SAXReader();
        Document document = reader.read(is);
        /** 获取根对象标签beans*/
        Element rootElement = document.getRootElement();
        //解析bean标签
        parseBean(rootElement);
    }

    /**
     * 解析bean标签
     * @param rootElement
     */
    private void parseBean(Element rootElement) {
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            String id = element.attributeValue("id");
            String className = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);
            List<Element> list = element.elements("property");
            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
            for (Element element1 : list) {
                String name = element1.attributeValue("name");
                String ref = element1.attributeValue("ref");
                String value = element1.attributeValue("value");
                PropertyValue propertyValue = new PropertyValue(name,ref,value);
                mutablePropertyValues.addPropertyValue(propertyValue);
            }
            beanDefinition.setPropertyValues(mutablePropertyValues);
            registry.registerBeanDefinition(id,beanDefinition);
        }
    }
}
