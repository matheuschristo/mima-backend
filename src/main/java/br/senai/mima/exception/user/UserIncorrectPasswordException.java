package br.senai.mima.exception.user;

public class UserIncorrectPasswordException extends RuntimeException{

	public UserIncorrectPasswordException(String message) {
		super(message);
	}
}
