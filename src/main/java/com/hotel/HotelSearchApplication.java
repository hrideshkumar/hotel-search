package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = {HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class HotelSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelSearchApplication.class, args);
	}

}
