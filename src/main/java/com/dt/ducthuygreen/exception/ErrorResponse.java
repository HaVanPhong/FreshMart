package com.dt.ducthuygreen.exception;

public class ErrorResponse {
	
	private Integer status;
	private String message;
	public ErrorResponse(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public ErrorResponse() {
		super();
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
