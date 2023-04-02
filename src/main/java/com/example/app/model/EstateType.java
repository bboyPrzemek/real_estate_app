package com.example.app.model;

import lombok.Getter;


public enum EstateType {
	
	flat ("Mieszkanie"), house("Dom"), garage("Garaż"), plot("Działka"), local("Lokal"), room("Pokój");
	
	@Getter
	private String displayName;
	
	private EstateType(String displayName) {
		this.displayName = displayName;
	}
}
