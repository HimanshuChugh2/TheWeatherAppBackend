package com.backend.weather.model;
/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
public class CustomResponse<T> {
	private boolean success;
	private String errorCode;
	private String errorMessage;
	private T data;

	public CustomResponse() {
		super();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public CustomResponse(boolean success, String errorCode, String errorMessage, T data) {
		super();
		this.success = success;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static <T> CustomResponse<T> ok(T data) {
		CustomResponse<T> response = new CustomResponse<>();
		response.success = true;
		response.data = data;
		return response;
	}

	public static <T> CustomResponse<T> error(String errorMessage, String errorCode) {
		CustomResponse<T> response = new CustomResponse<>();
		response.success = false;
		response.errorMessage = errorMessage;
		return response;
	}

	public static <T> CustomResponse<T> error(String errorMessage, String errorCode, T data) {
		CustomResponse<T> response = new CustomResponse<>();
		response.success = false;
		response.errorMessage = errorMessage;
		response.data = data;
		response.errorCode = errorCode;
		return response;
	}

	// getters and setters
}

// why static methods and call functions with class names?
//Using static methods for the error and ok methods in the CustomResponse class is a common practice to provide a convenient way to create instances of the CustomResponse class without having to explicitly create an instance of the class. This is known as a factory method pattern. Let's explore the reasons for this choice:
//
//Convenience: By making these methods static, you can call them directly on the class itself, without needing to create an instance of the class first. This makes the code more concise and easier to read.
//
//Fluent API: By chaining static method calls, you can create a fluent API that reads naturally and is easy to understand. For example, CustomResponse.ok(data) and CustomResponse.error("Error message") create instances of CustomResponse with appropriate values without the need for temporary variables.
//
//Encapsulation: These static methods encapsulate the process of creating instances of CustomResponse with specific success or error states. This encapsulation can help hide the internal implementation details of the CustomResponse class, making the code more maintainable and allowing you to change the implementation in the future without affecting the calling code.
//
//While you could technically instantiate the CustomResponse class and call instance methods to achieve the same result, using static factory methods is a common and established pattern in programming. It provides a more intuitive and readable way to create instances of classes, especially when the class represents a data structure or a container for a specific purpose, like a response entity.
