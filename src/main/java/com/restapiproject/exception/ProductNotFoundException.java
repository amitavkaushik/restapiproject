package com.restapiproject.exception;

import java.text.MessageFormat;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6430588277022921256L;

	private final String id;

	@Override
	public String getMessage() {
		return MessageFormat.format("A product with id ''{0}'' does not exist ", id);
	}
}
