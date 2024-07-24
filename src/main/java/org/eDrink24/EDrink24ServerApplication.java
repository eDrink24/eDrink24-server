package org.eDrink24;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.eDrink24.config")
public class EDrink24ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EDrink24ServerApplication.class, args);
	}

}
