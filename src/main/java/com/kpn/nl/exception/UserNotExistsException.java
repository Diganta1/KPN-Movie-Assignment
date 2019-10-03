package com.kpn.nl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author C28278
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotExistsException(String message) {
		super(message);
	}

}
