package com.backend.weather.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.backend.weather.dto.Location;
import com.backend.weather.dto.WeatherDataDto;
import com.backend.weather.dto.WeatherDetails;
import com.backend.weather.dto.WeatherSummaryDto;
import com.backend.weather.dto.Wind;
import com.backend.weather.model.CustomResponse;
import com.backend.weather.model.CustomResponseEntity;
import com.backend.weather.model.ErrorCodeConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
@Service
public class WeatherService {
	@Autowired
	private RestTemplate restTemplate;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WeatherService.class);

	public CustomResponseEntity<WeatherDataDto> getWeatherDataByCity(String cityname) {
		ObjectMapper objectMapper = new ObjectMapper();

		String units = "metric"; // represents celsius
		String apiKey = "54fc75040e01a4ed4abdb7bed20c762b";
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?";
		String fullApiUrl = apiUrl + "q=" + cityname + "&appid=" + apiKey + "&units=" + units + "&lang=" + "en";

		System.out.println(fullApiUrl);
		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		try {
			response = restTemplate.getForEntity(fullApiUrl, String.class);

		} catch (HttpClientErrorException e) {

			JsonNode jsonNode = null;
			try {
				jsonNode = objectMapper.readTree(e.getResponseBodyAsString());
			} catch (JsonMappingException ex) {
				ex.printStackTrace();
			} catch (JsonProcessingException ex) {
				ex.printStackTrace();
			}

			String cod = jsonNode.get("cod").asText();
			String message = jsonNode.get("message").asText();

			logger.debug("cod: " + cod);
			logger.debug("message: " + message);

			logger.debug(
					"inside catch  " + e.getMessage() + e.getMessage() + " &&&&&&& " + e.getResponseBodyAsString());

			if (cod.equals("404") && message.equals("city not found")) {
				return CustomResponseEntity.returnError(
						CustomResponse.error(ErrorCodeConstants.getErrorMessage(ErrorCodeConstants.CITY_NOT_FOUND),
								ErrorCodeConstants.CITY_NOT_FOUND, null),
						HttpStatus.NOT_FOUND, "");
			} else {
				return CustomResponseEntity.returnError(
						CustomResponse.error(ErrorCodeConstants.getErrorMessage(ErrorCodeConstants.UNKNOWN_ERROR),
								ErrorCodeConstants.UNKNOWN_ERROR, null),
						HttpStatus.NO_CONTENT, "");
			}
		}

		JsonNode fullApiResponseNode = null;
		JsonNode weatherSummaryNode = null;
		JsonNode locationNode = null;
		JsonNode weatherDetailsNode = null;
		JsonNode windNode = null;
		JsonNode sysNode = null;
		WeatherDetails weatherDetails = new WeatherDetails();
		WeatherDataDto weatherDataDto = new WeatherDataDto();
		Location location = new Location();
		Wind wind = new Wind();
		WeatherSummaryDto weatherSummary = new WeatherSummaryDto();
		try {
			fullApiResponseNode = objectMapper.readTree(response.getBody());
			weatherSummaryNode = fullApiResponseNode.get("weather").get(0);
			locationNode = fullApiResponseNode.get("coord");
			weatherDetailsNode = fullApiResponseNode.get("main");
			windNode = fullApiResponseNode.get("wind");
			sysNode = fullApiResponseNode.get("sys");

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		if (weatherSummaryNode != null) {
			// populating weather summary data
			weatherSummary.setDescription(weatherSummaryNode.get("description").asText());
			weatherSummary.setIcon(weatherSummaryNode.get("icon").asText());
			weatherSummary.setId(weatherSummaryNode.get("id").asText());
			weatherSummary.setMain(weatherSummaryNode.get("main").asText());
		}

		if (locationNode != null) {

			// populating location data
			location.setLatitude(locationNode.get("lat").asText());
			location.setLongitude(locationNode.get("lon").asText());
		}
		if (weatherDetailsNode != null) {
			// populating weather details data
			weatherDetails.setFeelsLike(weatherDetailsNode.get("feels_like").asText());
			// weatherDetails.setGroundLevel(weatherDetailsNode.get("grnd_level").asText());
			weatherDetails.setHumidity(weatherDetailsNode.get("humidity").asText());
			weatherDetails.setPressure(weatherDetailsNode.get("pressure").asText());
			// weatherDetails.setSealevel(weatherDetailsNode.get("sea_level").asText());
			weatherDetails.setTemperature(weatherDetailsNode.get("temp").asText());
			weatherDetails.setTemperatureMax(weatherDetailsNode.get("temp_max").asText());
			weatherDetails.setTemperatureMin(weatherDetailsNode.get("temp_min").asText());

		}
		if (windNode != null) {
			wind.setSpeed(windNode.get("speed").asText());
			wind.setDegree(windNode.get("deg").asText());
		}

		if (sysNode != null) {
			System.out.println("sysNode.get(\"country\").asText()" + sysNode.get("country").asText());
			weatherSummary.setCountry(sysNode.get("country").asText());
		}

		weatherDataDto.setWeatherSummary(weatherSummary);
		weatherDataDto.setLocation(location);
		weatherDataDto.setWeatherDetails(weatherDetails);
		weatherDataDto.setPlaceName(fullApiResponseNode.get("name").asText());
		weatherDataDto.setWind(wind);
		return CustomResponseEntity.returnSuccess(CustomResponse.ok(weatherDataDto), HttpStatus.OK);

	}

}
