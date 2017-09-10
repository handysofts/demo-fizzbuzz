package com.serviceflow.demofizzbuzz.enums;


import com.serviceflow.demofizzbuzz.models.MyError;

public enum Errors {
	
	OK (0, "No Error"),

	INCORRECT_FIZZ_BUZZ_NUMBERS(-10, "Incorrect request. Only numbers and comma symbol allowed"),


	NOT_FOUND(-404, "Not found"),
	NOT_IMPLEMENTED(-501, "Not Implemented"),
	
	UNKNOWN_ERROR(-9999, "Unknown error! Please contact vmustafayev@gmail.com");
	
	
	
	private int code;
	private String text;
	
	Errors(int code, String text){
		this.code = code;
		this.text = text;
	}

	
	public int getCode(){
		return code;
	}
	
	public String getText(){
		return text;
	}
	
	public MyError getValue(){
		return new MyError(code, text);
	}
}
