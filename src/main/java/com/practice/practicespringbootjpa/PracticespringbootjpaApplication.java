package com.practice.practicespringbootjpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//启动类：启动类应放于包的根下，启动类在启动时会扫描所有注解，Spring Boot所有配置都是基于注解的
@SpringBootApplication
@EnableScheduling // 开启定时任务支持

public class PracticespringbootjpaApplication {
	private static final Logger logger = LogManager.getLogger(PracticespringbootjpaApplication.class);

	public static void main(String[] args) {
		logger.info("Spring start");
		SpringApplication.run(PracticespringbootjpaApplication.class, args);
		logger.warn("Spring dddd");
	}

}
