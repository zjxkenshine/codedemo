package com.kenshine.config;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 8:25
 * @description：Swagger3配置
 * @modified By：
 * @version: $
 */

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "SpringBoot2.x 集成 Swagger3（springdoc-openapi-ui）",
                description = "SpringBoot2.x 集成 Swagger3（springdoc-openapi-ui） 测试文档", version = "1.0.0",
                license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"),
                contact = @Contact(name = "RtxTitanV", url = "https://blog.csdn.net/RtxTitanV", email = "RtxTitanV@xxx.com")),
        externalDocs = @ExternalDocumentation(description = "参考文档",
                url = "https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations"),
        security = @SecurityRequirement(name = "JWT"))
@SecurityScheme(name = "JWT", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer",
        in = SecuritySchemeIn.HEADER)
@Configuration
public class Swagger3Config {
}
