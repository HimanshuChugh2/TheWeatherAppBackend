package com.backend.weather.dto;
/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
public class WeatherDetails {
	private String temperature;
	private String feelsLike;
	private String temperatureMin;
	private String temperatureMax;
	private String pressure;
	private String humidity;
//	private String sealevel;
//	private String groundLevel;
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(String feelsLike) {
		this.feelsLike = feelsLike;
	}
	public String getTemperatureMin() {
		return temperatureMin;
	}
	public void setTemperatureMin(String temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	public String getTemperatureMax() {
		return temperatureMax;
	}
	public void setTemperatureMax(String temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
//	public String getSealevel() {
//		return sealevel;
//	}
//	public void setSealevel(String sealevel) {
//		this.sealevel = sealevel;
//	}
//	public String getGroundLevel() {
//		return groundLevel;
//	}
//	public void setGroundLevel(String groundLevel) {
//		this.groundLevel = groundLevel;
//	}
	public WeatherDetails(String temperature, String feelsLike, String temperatureMin, String temperatureMax,
			String pressure, String humidity, String sealevel, String groundLevel) {
		super();
		this.temperature = temperature;
		this.feelsLike = feelsLike;
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
		this.pressure = pressure;
		this.humidity = humidity;
//		this.sealevel = sealevel;
//		this.groundLevel = groundLevel;
	}
	public WeatherDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
