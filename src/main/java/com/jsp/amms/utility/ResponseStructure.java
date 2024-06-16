package com.jsp.amms.utility;

public class ResponseStructure<T> {
	
	private T data;
	private int status;
	private String message;
	public T getData() {
		return data;
	}
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public ResponseStructure<T> setData(T data) {
		this.data = data;
		return this;
	}
	public ResponseStructure<T> setStatus(int status) {
		this.status = status;
		return this;
	}
	public ResponseStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	
	

}
