package com.g3softwares.sipe.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.g3softwares.sipe.api.config.propery.SipeApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(SipeApiProperty.class)
public class SipeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SipeApiApplication.class, args);
	}
}
