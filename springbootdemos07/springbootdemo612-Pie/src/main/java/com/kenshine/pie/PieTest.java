package com.kenshine.pie;

import com.feiniaojin.ddd.ecosystem.pie.BootStrap;
import com.kenshine.pie.handlers.ArticleModifyContentHandler;
import com.kenshine.pie.handlers.ArticleModifyTitleHandler;
import com.kenshine.pie.handlers.CheckParameterHandler;
import com.kenshine.pie.handlers.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by kenshine
 * @Classname Test
 * @Description 使用测试
 * @Date 2023-12-21 8:32
 * @modified By：
 * @version: 1.0$
 */
public class PieTest {
    private final static Logger logger = LoggerFactory.getLogger(PieTest.class);

    public static void main(String[] args) {
        //入参
        ArticleTitleModifyCmd dto = new ArticleTitleModifyCmd();
        dto.setArticleId("articleId_001");
        dto.setTitle("articleId_001_title");
        dto.setContent("articleId_001_content");
        //创建引导类
        BootStrap bootStrap = new BootStrap();
        Result result = (Result) bootStrap
                //入参
                .inboundParameter(dto)
                //出参工厂
                .outboundFactory(new ResultFactory())
                //自定义channel
                .channel(new ArticleModifyChannel())
                //第一个handler
                .addChannelHandlerAtLast("checkParameter", new CheckParameterHandler())
                //第二个handler
                .addChannelHandlerAtLast("modifyTitle", new ArticleModifyTitleHandler())
                //第三个handler
                .addChannelHandlerAtLast("modifyContent", new ArticleModifyContentHandler())
                //异常处理handler
                .addChannelHandlerAtLast("exception", new ExceptionHandler())
                //执行
                .process();
        //result为执行结果
        logger.info("result:code={},msg={}", result.getCode(), result.getMsg());
    }
}
