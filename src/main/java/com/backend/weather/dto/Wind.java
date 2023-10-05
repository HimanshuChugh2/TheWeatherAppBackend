package com.backend.weather.dto;
/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
public class Wind {
private String speed;
private String degree;
public String getSpeed() {
	return speed;
}
public void setSpeed(String speed) {
	this.speed = speed;
}
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public Wind(String speed, String degree) {
	super();
	this.speed = speed;
	this.degree = degree;
}
public Wind() {
	super();
	// TODO Auto-generated constructor stub
}


}
