import com.kenshine.MailApp;
import com.kenshine.utils.MailUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 14:46
 * @description： 测试邮件发送
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MailApp.class)
public class TestSpringbootEmail {

    @Autowired
    private MailUtils mailUtils;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     *  简单文本邮件发送
     */
    @Test
    public void sendSimpleMailTest(){
        mailUtils.sendSimpleMail("1754294529@qq.com","简单文本邮件","这是我的第一封邮件,哈哈...");
    }

    /**
     *  HTML邮件发送
     *
     * @throws Exception
     */
    @Test
    public void sendHtmlMailTest() throws Exception{

        String content = "<html>\n"+
                "<body>\n" +
                "<h1 style=\"color: red\"> hello world , 这是一封HTML邮件</h1>"+
                "</body>\n"+
                "</html>";


        mailUtils.sendHtmlMail("1754294529@qq.com","Html邮件发送",content);
    }

    /**
     *  发送副本邮件
     *
     * @throws Exception
     */
    @Test
    public void sendAttachmentMailTest() throws Exception{
        String filepath = "D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo23-Mail\\src\\main\\resources\\1.jpg";
        mailUtils.sendAttachmentMail("1754294529@qq.com","发送副本","这是一篇带附件的邮件",filepath);
    }

    /**
     *  发送图片邮件
     *
     * @throws Exception
     */
    @Test
    public void sendImageMailTest() throws Exception{
        //发送多个图片的话可以定义多个 rscId,定义多个img标签

        String filePath = "D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo23-Mail\\src\\main\\resources\\1.jpg";
        String rscId = "ligh001";
        String content = "<html><body> 这是有图片的邮件: <img src=\'cid:"+rscId+"\'> </img></body></html>";

        mailUtils.sendImageMail("1754294529@qq.com","这是一个带图片的邮件",content,filePath,rscId);
    }

    /**
     *  发送邮件模板
     *
     * @throws Exception
     */
    @Test
    public void sendTemplateEmailTest() throws Exception {
        Context context = new Context();
        context.setVariable("id","006");
        context.setVariable("name","kenshine");
        String emailContent = templateEngine.process("emailTemplate",context);
        mailUtils.sendHtmlMail("1754294529@qq.com","这是一个模板文件",emailContent);
    }


}
