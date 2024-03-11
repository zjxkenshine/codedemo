package com.kenshine.xmlpull;

import com.kenshine.xmlpull.model.ClassBean;
import com.kenshine.xmlpull.model.StudentBean;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname XmlpullTest
 * @Description 使用测试
 * @Date 2024-03-11 11:23
 * @modified By：
 * @version: 1.0$
 */
public class XmlpullTest {

    /**
     * 解析test01.xml
     */
    @Test
    public void test01() throws XmlPullParserException, IOException {
        FileInputStream is = new FileInputStream("xml\\test01.xml");
        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        parser.setInput(is, "utf-8");
        List<ClassBean> list = new ArrayList<>();
        int event = parser.getEventType();
        while (event != XmlPullParser.END_DOCUMENT) {
            switch (event) {
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.START_TAG:
                    if ("class".equals(parser.getName())) {
                        ClassBean bean = new ClassBean();
                        bean.setId(parser.getAttributeValue(0));
                        bean.setName(parser.nextText());
                        list.add(bean);
                    }
                    break;
                default:
                    break;
            }
            event = parser.next();
        }
        System.out.println(list);
    }

    /**
     * 解析test02.xml
     */
    @Test
    public void test02() throws FileNotFoundException {
        FileInputStream is = new FileInputStream("xml\\test02.xml");
        List<ClassBean> list = null;
        ClassBean bean = null;
        List<StudentBean> sList = null;
        StudentBean be = null;
        try {
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(is, "utf-8");
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                        list = new ArrayList<>();
                        break;
                    case XmlPullParser.START_TAG:
                        if ("class".equals(parser.getName())) {
                            bean = new ClassBean();
                            bean.setId(parser.getAttributeValue(0));
                            bean.setName(parser.getAttributeValue(1));
                            sList = new ArrayList<>();
                        } else if ("student".equals(parser.getName())) {
                            be = new StudentBean();
                            be.setId(parser.getAttributeValue(0));
                            be.setName(parser.nextText());
                            sList.add(be);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("class".equals(parser.getName())) {
                            bean.setList(sList);
                            list.add(bean);
                            bean = null;
                        }
                        break;
                    default:
                        break;
                }
                event = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }

    /**
     * 解析test03.xml
     */
    @Test
    public void test03() throws FileNotFoundException {
        FileInputStream is = new FileInputStream("xml\\test03.xml");
        List<ClassBean> list = null;
        ClassBean bean = null;
        List<StudentBean> sList = null;
        StudentBean be = null;
        try {
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(is, "utf-8");
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                        list = new ArrayList<ClassBean>();
                        break;
                    case XmlPullParser.START_TAG:
                        if ("class".equals(parser.getName())) {
                            bean = new ClassBean();
                            bean.setId(parser.getAttributeValue(0));
                            bean.setName(parser.getAttributeValue(1));
                            sList = new ArrayList<StudentBean>();
                        } else if ("student".equals(parser.getName())) {
                            be = new StudentBean();
                            be.setId(parser.getAttributeValue(0));
                            sList.add(be);
                        } else if ("name".equals(parser.getName())) {
                            be.setName(parser.nextText());
                        } else if ("sex".equals(parser.getName())) {
                            be.setSex(parser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("class".equals(parser.getName())) {
                            bean.setList(sList);
                            list.add(bean);
                            bean = null;
                        }
                        break;
                    default:
                        break;
                }
                event = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
