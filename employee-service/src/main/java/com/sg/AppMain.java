/*
 * The main class for Spring Boot application
 */

package com.sg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan({ "com.sg" })
@Import({ EmbeddedServletContainerAutoConfiguration.class, DispatcherServletAutoConfiguration.class,
		ServerPropertiesAutoConfiguration.class, AopAutoConfiguration.class, JerseyAutoConfiguration.class })

/**
 * @author Manju Kumar Mohan
 *
 */
@Configuration
@SpringBootApplication
@EnableSwagger2
public class AppMain {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AppMain.class);
		app.run(args);

	}

}
