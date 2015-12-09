package com.goeuro.exception;

public class NoInputException extends Exception {

	private static final long serialVersionUID = 4935091068319906404L;
	
	public NoInputException(){}
	
	public NoInputException(String message){
		super(message);
	}
	
}
