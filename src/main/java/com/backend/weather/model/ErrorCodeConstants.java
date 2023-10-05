package com.backend.weather.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
public final class ErrorCodeConstants {
	private ErrorCodeConstants() {
		// Private constructor to prevent instantiation
	}

	public static final String CITY_NOT_FOUND = "ERR001";
	public static final String UNKNOWN_ERROR = "ERR002";

	// Define a map to store error messages for each error code
	private static final Map<String, String> ERROR_MESSAGES = new HashMap<>();
	static {
		ERROR_MESSAGES.put(CITY_NOT_FOUND, "The city name you entered was not found, please try again ");
		ERROR_MESSAGES.put(UNKNOWN_ERROR, "Unknown Error");
	}

	public static String getErrorMessage(String errorCode) {
		return ERROR_MESSAGES.getOrDefault(errorCode, "Unknown error");
	}
}
//for future use
//public CustomResponseEntity<Object> handleException(Exception e) {
//    CustomResponse<Object> customResponse = new CustomResponse<>();
//    customResponse.setSuccess(false);
//
//    String errorCode;
//    if (e instanceof CityNotFoundException) {
//        errorCode = ErrorCodeConstants.CITY_NOT_FOUND;
//    } else {
//        errorCode = ErrorCodeConstants.RESOURCE_NOT_FOUND;
//    }
//
//    customResponse.setErrorCode(errorCode);
//    customResponse.setErrorMessage(ErrorCodeConstants.getErrorMessage(errorCode));
//
//    return CustomResponseEntity.create(customResponse, HttpStatus.NOT_FOUND);
//}