package com.temp.exception.webExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="Unauthorized User")
public class UnAuthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
