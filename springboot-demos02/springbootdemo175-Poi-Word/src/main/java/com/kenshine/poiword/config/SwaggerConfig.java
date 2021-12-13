package com.kenshine.poiword.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 9:22
 * @description：Swagger配置
 * @modified By：
 * @version: $
 */
@Configuration //让Spring来加载该类配置
@EnableSwagger2 //启用Swagger2
public class SwaggerConfig {

    @Bean
    public Docket dataManagerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("POI解析word文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kenshine.poiword.web"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("POI解析word文档")
                .description("POI解析word文档，包括doc和docx格式")
                .termsOfServiceUrl("-----")
                .version("1.0").build();
    }


}
