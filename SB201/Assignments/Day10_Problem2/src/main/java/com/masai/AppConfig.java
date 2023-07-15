package com.masai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public Car car() {
		return new Car();
	}

	@Bean
	public Bike bike() {
		return new Bike();
	}

	@Bean
	public Travel travel() {
		return new Travel(car(), bike());
	}
}