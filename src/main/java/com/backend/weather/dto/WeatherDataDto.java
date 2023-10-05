package com.backend.weather.dto;
/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
public class WeatherDataDto {
	private String placeName;
	private WeatherDetails weatherDetails;
	private WeatherSummaryDto weatherSummary;
	private Wind wind;

	private Location location;

	public WeatherSummaryDto getWeatherSummary() {
		return weatherSummary;
	}

	public void setWeatherSummary(WeatherSummaryDto weatherSummary) {
		this.weatherSummary = weatherSummary;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

 

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public WeatherDetails getWeatherDetails() {
		return weatherDetails;
	}

	public void setWeatherDetails(WeatherDetails weatherDetails) {
		this.weatherDetails = weatherDetails;
	}

 

	public WeatherDataDto(String placeName, WeatherDetails weatherDetails, WeatherSummaryDto weatherSummary, Wind wind,
			Location location) {
		super();
		this.placeName = placeName;
		this.weatherDetails = weatherDetails;
		this.weatherSummary = weatherSummary;
		this.wind = wind;
		this.location = location;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public WeatherDataDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
