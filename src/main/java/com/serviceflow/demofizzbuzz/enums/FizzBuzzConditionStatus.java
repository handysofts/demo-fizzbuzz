package com.serviceflow.demofizzbuzz.enums;

public enum FizzBuzzConditionStatus {

    DEACTIVATED(0),
    ACTIVE(1);

	private final int value;
    FizzBuzzConditionStatus(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
