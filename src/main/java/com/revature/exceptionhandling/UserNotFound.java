package com.revature.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException {

	private String msg;
	public UserNotFound(String msg){
		super(msg);
		this.msg=msg;
	}
}
