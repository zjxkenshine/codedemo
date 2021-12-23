package com.kensine.saxon.xml;

import com.kensine.saxon.domain.User;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.Push;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/23 9:04
 * @description：Event API 构建XML
 * @modified By：
 * @version: $
 */
public class EventDemo {

    public static void main(String[] args) throws SaxonApiException {
        Processor processor = new Processor(false);
        Serializer destination = processor.newSerializer(new File("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo197-Saxon\\src\\main\\resources\\saxon\\xml\\event.xml"));
        destination.setOutputProperty(Serializer.Property.INDENT, "no");
        Push.Document doc = processor.newPush(destination).document(true);
        doc.setDefaultNamespace("http://www.example.org/ns");
        Push.Element top = doc.element("root");
        top.attribute("version", "1.5");

        List<User> users = new ArrayList<>();
        users.add(new User(1,"kenshine"));
        users.add(new User(2,"qin"));

        for (User user : users) {
            top.element("user")
                    .attribute("id", user.getId().toString())
                    .text(user.getName());
        }
        doc.close();
    }
}
