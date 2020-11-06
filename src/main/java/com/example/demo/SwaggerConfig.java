package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import io.swagger.models.Tag;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 
	 @Bean
	 public Docket api() {                
	     return new Docket(DocumentationType.SWAGGER_2)  
	    		 .apiInfo(apiInfo())
	       .select()                                       
	       .apis(RequestHandlerSelectors.withClassAnnotation((RestController.class)))
	       .paths(PathSelectors.any())                     
	       .build();
	 }
	 
	 
	 @Bean
	    public ApiInfo apiInfo() {
	        final ApiInfoBuilder builder = new ApiInfoBuilder();
	        builder.title("Proyecto Demo").version("1.0").license("(C) Copyright Demo")
	        .description("APIs de mi aplicacion Demo hanoli");
	        return builder.build();
	        }
	
}
