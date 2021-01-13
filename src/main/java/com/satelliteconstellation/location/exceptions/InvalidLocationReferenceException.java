package com.satelliteconstellation.location.exceptions;

public class InvalidLocationReferenceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public InvalidLocationReferenceException(String errorMessage) {
        super(errorMessage);
    }


}
