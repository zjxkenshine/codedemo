package com.kenshine.jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author by kenshine
 * @Classname JsoupTest
 * @Description 测试
 * @Date 2023-10-20 17:32
 * @modified By：
 * @version: 1.0$
 */
public class JsoupTest {
    public static void main(String[] args) {
        Document doc=JsoupUtil.getDoc1("http://192.168.0.7:8181/login/");
        //doc是我们通过第一步获得的doucmen对象。select括号里面的意思是class为content-item和expert的a标签元素。
        //多个class记得要用逗号隔开。
        //其中的 “a” 可以是 “div”、“span”等标签名。
        Elements  contentEs = doc.select("a.content-item,expert");

        //因为获得的不是一个元素，所以使用get(index)方法，获得对应的元素，以0开始。
        Element contentE = contentEs.get(0);

        //也可以使用增强型for循环将它遍历。其中.attr()方法是获得该元素的某某属性值，比如a标签的href值。
        for(Element e : contentEs ){
            e.attr("href");
        }

        //如果一次select()方法没用选到具体的，可以多次使用该方法。下面就调用了三次select()方法。
        Elements e = doc.select("div.menu-item,menu-skincare");
        Elements ee = e.select("div.column");
        for(int i=0 ; i<ee.size();i++){
            Elements eee = ee.get(i).select("a.submenu-item");
            String result  = eee.text();
            System.out.println(result);
        }

    }
}
