package com.creditsuisse.orderbook.app.config;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * This class is spring boot configuration class which is used to start the
 * spring application.
 * 
 * @author Tarun Rohila
 * @since Nov 28, 2018
 */
@Import({ AppConfig.class,DBConfig.class})
@SpringBootApplication(scanBasePackages = { "com.creditsuisse.orderbook.app" })
//@AutoConfigureTestDatabase
public class BookOrderApp extends SpringBootServletInitializer {

	/**
	 * Method to configure web application
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BookOrderApp.class);
	}

	/**
	 * Spring boot application's run method
	 * 
	 * @param String array arguments
	 */
	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(BookOrderApp.class);
		sa.setLogStartupInfo(false);
		sa.setBannerMode(Banner.Mode.OFF);
		sa.run(args);
	}

}
