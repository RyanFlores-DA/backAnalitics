package com.da.analitics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.da.analitics.domain")
@SpringBootApplication
public class AnaliticsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnaliticsApplication.class, args);
	}

}
