package com.backend.weather.dto;
/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
public class WeatherSummaryDto {
  private String id;
  private String main;
  private String description;
  private String icon;
  private String country;
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getMain() {
	return main;
}
public void setMain(String main) {
	this.main = main;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getIcon() {
	return icon;
}
public void setIcon(String icon) {
	this.icon = icon;
}
 
public WeatherSummaryDto(String id, String main, String description, String icon, String country) {
	super();
	this.id = id;
	this.main = main;
	this.description = description;
	this.icon = icon;
	this.country = country;
}
public WeatherSummaryDto() {
	super();
	// TODO Auto-generated constructor stub
}

}
