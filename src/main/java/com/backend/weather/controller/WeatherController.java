package com.backend.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.backend.weather.dto.WeatherDataDto;
import com.backend.weather.model.CustomResponseEntity;
import com.backend.weather.service.WeatherService;
/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping("/weather")
	public CustomResponseEntity<WeatherDataDto> getWeatherData(@RequestParam("cityname") String cityname) {

		CustomResponseEntity<WeatherDataDto> response = weatherService.getWeatherDataByCity(cityname);

		return response == null ? null : response;

	}

}
