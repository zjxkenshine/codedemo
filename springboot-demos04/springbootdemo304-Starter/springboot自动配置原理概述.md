# AutoConfiguration自动配置概述
## 1.@SpringBootApplication
组合注解，主要注解：
- `@ComponentScan`：
    - 自动扫描被`@Service`,`@Repository`,`@Component`,`@Controller`标记的类，最终生成IOC容器中的bean
    - basePackages，includeFilters，excludeFilters属性
- `@SpringBootConfiguration`：
    - 与@Configuration作用相同，声明当前类是一个配置类
    - `@Configuration`
      - `@Component`
- `@EnableAutoConfiguration`：springboot实现自动化配置的核心注解
 
# 2.@EnableAutoConfiguration
组合注解，主要注解：
- `@AutoConfigurationPackage`：将主程序类所在包及所有子包下的组件到扫描到spring容器中
   - `@Import(AutoConfigurationPackages.Registrar.class)`：将Registrar这个组件类导入到容器中
- `@Import(AutoConfigurationImportSelector.class)`：把AutoConfigurationImportSelector组件导入到容器

## 3.AutoConfigurationImportSelector
处理自动导入的主要类
- `selectImports(AnnotationMetadata)`：annotationMetadata 是＠import所用在的注解．这里指定是@EnableAutoConfiguration
- `getAutoConfigurationEntry`：获取AutoConfigrationEntry(包含configurations和exclusions)
    - `getCandidateConfigurations`：通过SpringFactoriesLoader加载jar包里面META-INF/spring.factories中的配置类
    - `getExclusions`：获取注解中配置的以及spring.autoconfigure.exclude配置的需要排除的类列表

## 4.SpringFactoriesLoader
springbootdemo178-SpringFactoriesLoader