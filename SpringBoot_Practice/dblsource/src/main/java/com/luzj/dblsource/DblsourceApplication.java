package com.luzj.dblsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DblsourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DblsourceApplication.class, args);
	}
}
