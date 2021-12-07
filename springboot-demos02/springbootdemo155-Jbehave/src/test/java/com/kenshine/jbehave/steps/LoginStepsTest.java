package com.kenshine.jbehave.steps;

import com.kenshine.jbehave.JBehaveApp;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.jbehave.core.reporters.Format.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/7 10:42
 * @description：
 * @modified By：
 * @version: $
 *
 * 执行：JUnitStories中的run方法
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JBehaveApp.class)
public class LoginStepsTest extends JUnitStories {
    @Autowired
    private ApplicationContext context;

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
               // .useStoryParser(new RegexStoryParser(new ExamplesTableFactory(new LoadFromClasspath(this.getClass()))))
                .useStoryReporterBuilder(new StoryReporterBuilder().withRelativeDirectory("doc/jbehave")
                        .withCodeLocation(CodeLocations.codeLocationFromClass(getClass())).withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML, XML));
    }


    /**
     * story文件路径
     * @return
     */
    @Override
    protected List<String> storyPaths() {
        List<String> result = new StoryFinder().findPaths("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo155-Jbehave\\src\\main\\resources", "**/*.story", "");
        System.out.println("storyPaths:" + result);
        return result;
    }

    /**
     * 注入steps
     * @return
     */
    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(configuration(), context());
    }

    private ApplicationContext context() {
        return context;
    }
}