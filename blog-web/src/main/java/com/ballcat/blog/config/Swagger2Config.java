package com.ballcat.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-07 22:33
 * @description
 */
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ballcat.blog.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Blog接口文档")
                .description("一个小而美的博客")
                .version("1.0")
                .build();
    }

    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> schemeList = new ArrayList<>();
        ApiKey securityScheme = new ApiKey("Authorization", "Authorization", "header");
        schemeList.add(securityScheme);
        return schemeList;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> contextList = new ArrayList<>();
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", scopes()));
        contextList.add(SecurityContext
                .builder()
                .securityReferences(securityReferences)
                .build());
        return contextList;
    }

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{new AuthorizationScope("global", "accessAnything")};
    }
}
