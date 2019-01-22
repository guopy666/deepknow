package com.gpy.deepdemo.config;

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
 * @Description:
 * @Author: gpy
 * @CreateDate: 2019/1/21 11:05
 * @Version: 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(newApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gpy.deepdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo newApiInfo(){
        return new ApiInfoBuilder()
                .title("Deepknow System API ")
                .description("deepknow system API")
                .termsOfServiceUrl("http://localhost:9090/")
                .version("1.0")
                .contact("guopy")
                .build();
    }
}
