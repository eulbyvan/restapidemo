package com.enigmacamp.exception;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 30/11/22
 */

public class NotFoundException extends RuntimeException {
	public NotFoundException(String s) {
		super("data not found");
	}
}
