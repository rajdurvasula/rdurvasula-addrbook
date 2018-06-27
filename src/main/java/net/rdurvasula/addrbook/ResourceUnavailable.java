package net.rdurvasula.addrbook;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceUnavailable extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4230582925301651333L;

	public ResourceUnavailable(String msg) {
		super(msg);
	}
	
	public ResourceUnavailable(String msg, Throwable cause) {
		super(msg, cause);
	}
}
