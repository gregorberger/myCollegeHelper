package com.project.myCollegeHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyCollegeHelperApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MyCollegeHelperApplication.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(MyCollegeHelperApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
	}

}
