package com.kenshine.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 16:57
 * @description：Swagger3配置
 * @modified By：
 * @version: $
 *
 * 访问地址
 * localhost:8080/doc.html
 * localhost:8080/swagger-ui
 */
@Configuration
@EnableOpenApi
@EnableKnife4j
public class Swagger3Config {

    /**
     * 配置默认分组
     *
     * @return springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket defaultApi() {
        // DocumentationType.OAS_30为Swagger3的文档类型
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo()).select()
                /*
                 * 通过apis和paths方法设置ApiSelector的构建规则
                 * ApiSelectorBuilder apis(Predicate<RequestHandler> selector)
                 *     RequestHandlerSelectors.any()：构建所有API
                 *     RequestHandlerSelectors.none()：所有API都不构建
                 *     RequestHandlerSelectors.basePackage()：构建指定包路径下的所有API
                 *     RequestHandlerSelectors.withClassAnnotation()：仅构建带有指定类注解的API
                 *     RequestHandlerSelectors.withMethodAnnotation()：仅构建带有指定方法注解的API
                 * ApiSelectorBuilder paths(Predicate<String> selector)
                 *     PathSelectors.any()：构建所有请求路径的API
                 *     PathSelectors.none()：所有请求路径的API都不构建
                 *     PathSelectors.regex()：仅构建正则匹配的请求路径的API
                 *     PathSelectors.ant()：仅构建与ant模式匹配的API
                 */
                .apis(RequestHandlerSelectors.basePackage("com.kenshine.controller.other")).paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置user分组
     *
     * @return springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
                // 通过securitySchemes和securityReferences方法进行JWT配置
                .securitySchemes(Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER.name("JWT").build()))
                .securityContexts(Collections.singletonList(SecurityContext.builder()
                        .securityReferences(Collections.singletonList(
                                SecurityReference.builder().scopes(new AuthorizationScope[0]).reference("JWT").build()))
                        .operationSelector(operationContext -> operationContext.requestMappingPattern().matches("/.*"))
                        .build()))
                .select().apis(RequestHandlerSelectors.basePackage("com.kenshine.controller.user"))
                // groupName方法设置分组名称
                .paths(PathSelectors.regex("/user/.*")).build().groupName("user");
    }

    /**
     * 配置order分组
     *
     * @return springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket orderApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER.name("JWT").build()))
                .securityContexts(Collections.singletonList(SecurityContext.builder()
                        .securityReferences(Collections.singletonList(
                                SecurityReference.builder().scopes(new AuthorizationScope[0]).reference("JWT").build()))
                        .operationSelector(operationContext -> operationContext.requestMappingPattern().matches("/.*"))
                        .build()))
                .select().apis(RequestHandlerSelectors.basePackage("com.kenshine.controller.order"))
                .paths(PathSelectors.regex("/order/.*")).build().groupName("order");
    }

    /**
     * 构建API文档基本信息
     *
     * @return springfox.documentation.service.ApiInfo
     */
    private ApiInfo apiInfo() {
        // 联系人信息：分别为作者、主页、邮箱
        Contact contact = new Contact("kenshine", "https://github.com/zjxkenshine", "kenshine@xxx.com");
        // 构建API文档的详细信息：依次为API标题、API描述、API联系人信息、API版本、API许可、API许可Url
        return new ApiInfoBuilder().title("SpringBoot2.x 集成 Swagger3").description("SpringBoot2.x 集成 Swagger3 测试文档")
                .contact(contact).version("1.0.0").license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0").build();
    }

}
