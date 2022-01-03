package com.kenshine.qdox.demo08;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.DocletTag;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 10:31
 * @description：DocletTag测试
 * @modified By：
 * @version: $
 */
public class DocletTagTest {
    public static void main(String[] args) throws IOException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        builder.addSource(new File("springbootdemo220-QDox\\src\\main\\java\\com\\kenshine\\qdox\\demo08\\Demo08.java"));
        //获取具体的javaclass
        JavaClass cls = builder.getClassByName("com.kenshine.qdox.demo08.Demo08");

        JavaMethod mth = cls.getMethods().get(0);

        String comment = mth.getComment();        // "This method does nothing at all."
        System.out.println(comment);

        //@returns标签
        DocletTag returns = mth.getTagByName("returns");
        returns.getName(); // "returns";
        returns.getValue(); // "A boolean of whether we care or not."

        //@param标签组
        List<DocletTag> params = mth.getTagsByName("param");
        params.get(0).getValue(); // "Someone's email address."
        params.get(1).getValue(); // "Date of birth."

        //@permission标签
        DocletTag permission = mth.getTagByName("permission");
        System.out.println(permission.getParameters());

        //@webservice标签
        DocletTag webservice = mth.getTagByName("webservice");
        webservice.getNamedParameter("type"); // "rpc"
        webservice.getNamedParameter("name"); // "myservice"
        System.out.println(webservice);
    }
}
