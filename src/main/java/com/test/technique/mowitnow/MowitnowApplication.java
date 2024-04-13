package com.test.technique.mowitnow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MowitnowApplication {

    public static void main(String[] args) {
		SpringApplication.run(MowitnowApplication.class, args);
	}

}
