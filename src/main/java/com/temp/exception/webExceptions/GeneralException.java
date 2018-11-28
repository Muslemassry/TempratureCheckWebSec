package com.temp.exception.webExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal Error, Kindly consult your admin")
public class GeneralException extends RuntimeException {
	public GeneralException(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = 1L;
}
