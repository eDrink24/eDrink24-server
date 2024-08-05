package org.eDrink24;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("org.eDrink24.config")
public class EDrink24ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EDrink24ServerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		System.out.println("WebMvcConfigurer.addCorsMappings");
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("http://localhost:3000","*");
			}
		};
	}

	// Test
}
