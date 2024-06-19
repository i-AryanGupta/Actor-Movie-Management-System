package com.jsp.amms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MovieNotFoundException extends RuntimeException {
	
	private String message;

}
