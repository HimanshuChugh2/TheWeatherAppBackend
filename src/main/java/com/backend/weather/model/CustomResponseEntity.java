package com.backend.weather.model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
//the CustomResponseEntity class wraps a CustomResponse object and extends ResponseEntity. The CustomResponse class (not shown here) would be responsible for holding the actual response data and metadata like success status, error messages, etc.
public class CustomResponseEntity<T> extends ResponseEntity<CustomResponse<T>> {

    private CustomResponseEntity(CustomResponse<T> body, HttpStatus status) {
        super(body, status);
    }

    public static <T> CustomResponseEntity<T> returnSuccess(CustomResponse<T> response, HttpStatus status) {
        return new CustomResponseEntity<>(response, status);
    }

    public static <T> CustomResponseEntity<T> returnError(CustomResponse<T> response,HttpStatus status, String message) {
        return new CustomResponseEntity<>(response, status);
    }

//    public static <T> CustomResponseEntity<T> error(CustomResponse<T> response,HttpStatus status, String message) {
//        return new CustomResponseEntity<>(CustomResponse.error(message, data), status);
//    }
}
