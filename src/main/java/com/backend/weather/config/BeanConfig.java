package com.backend.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
@Configuration
public class BeanConfig {
	@Bean
	public RestTemplate creaRestTemplate() {
		return new RestTemplate();
	}

}