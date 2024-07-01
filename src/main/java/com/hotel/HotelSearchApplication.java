package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication//(exclude = {HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class HotelSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelSearchApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
