package com.mockst.mocking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.mockst.mocking.module.*.dao"})
public class MockingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockingApplication.class, args);
	}

}
