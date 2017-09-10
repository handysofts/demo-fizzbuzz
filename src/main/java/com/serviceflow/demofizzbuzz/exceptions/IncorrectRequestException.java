package com.serviceflow.demofizzbuzz.exceptions;


import com.serviceflow.demofizzbuzz.enums.Errors;

/**
 * My Custom exception which contains error code and text
 */
public class IncorrectRequestException extends RuntimeException {

	private Errors err;

	public IncorrectRequestException(Errors err){
		super(err.getText());
		this.err = err;
	}

	public Errors getErr() {
		return err;
	}
	
}
