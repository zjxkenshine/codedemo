package com.kenshine.typefilter.demo01.config;

import com.kenshine.typefilter.demo01.MyTypeFilter;
import com.kenshine.typefilter.demo01.Person;
import com.kenshine.typefilter.demo01.annotation.Custom;
import com.kenshine.typefilter.demo01.service.TestService;
import org.springframework.context.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 8:43
 * @description：
 * @modified By：
 * @version: $
 */
//配置类==配置文件--只是以java代码的方式
@Configuration
//多指定几个ComponetScan规则
//只要标注了@Controller、@Service、@Repository，@Component都会被扫描
@ComponentScans(
        value = {
                @ComponentScan(value = "com.kenshine.typefilter.demo01",includeFilters = {
                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Custom.class}),
                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {TestService.class}),
                        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
                },useDefaultFilters = false)
        }
)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//useDefaultFilters 默认为true，若使用includeFilters只指定某个，需要设置为false
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {
    @Bean("person")
    public Person person01() {
        return new Person("kenshine",18);
    }

}
