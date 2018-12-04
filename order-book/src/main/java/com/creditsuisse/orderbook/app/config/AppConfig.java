package com.creditsuisse.orderbook.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is configuration class for book order application to do all common configuration in it.
 * 
 * @author Tarun Rohila
 * @since Nov 28, 2018
 */
@Configuration
@EnableSwagger2
public class AppConfig {
	
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.creditsuisse.orderbook.app.controller"))
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(metaData());
	    }
	    private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo(
	                "REST API",
	                "REST API for Order Book",
	                "1.0",
	                "Terms of service",
	                new Contact("Tarun Rohila", "http://localhost:7777/order-book", "tarunrohila@gmail.com"),
	               "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0");
	        return apiInfo;
	    }

}
