package com.example.demo;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebMvcConfiguration extends WebMvcConfigurationSupport{

	 public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    // Make Swagger meta-data available via <baseURL>/v2/api-docs/
	    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	    // Make Swagger UI available via <baseURL>/swagger-ui.html
	    registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/");
	  }
	 
}
