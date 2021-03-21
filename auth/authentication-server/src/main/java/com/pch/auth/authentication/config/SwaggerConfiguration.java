package com.pch.auth.authentication.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

import com.github.xiaoymin.knife4j.core.util.CollectionUtils;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * <P> swagger 文档配置类 </P>
 *
 * @Author: pch
 * @Date: 2021/2/21
 */
@Configuration
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Bean(value = "authenticationApi")
    @Order(value = 1)
    public Docket authenticationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pch.auth.authentication.rest"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(CollectionUtils.newArrayList(securityContext()))
                .securitySchemes(CollectionUtils.newArrayList(apiKey()));
    }

    private ApiInfo groupApiInfo() {
        return new ApiInfoBuilder()
                .title("权限管理")
                .description("<div style='font-size:14px;color:red;'> 认证管理 APIs</div>")
                .termsOfServiceUrl("http://www.google.com")
                .contact("group@qq.com")
                .version("1.0")
                .build();
    }


    private ApiKey apiKey() {
        return new ApiKey("Bearer ", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return CollectionUtils.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }

}
