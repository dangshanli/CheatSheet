package com.luzj.ch8_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching//打开缓存支持,使用默认的ConcurrentMapCacheManager作为缓存技术
public class Ch85Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch85Application.class, args);
	}
}
