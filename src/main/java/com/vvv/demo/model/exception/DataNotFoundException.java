package com.vvv.demo.model.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataNotFoundException extends Exception {
	private static final Logger logger = LoggerFactory.getLogger(DataNotFoundException.class);
	private Integer id;

	public DataNotFoundException(Integer id) {
		super(id.toString());
		this.id = id;
		logger.error(this.getMessage());
	}

	@Override
	public String getMessage() {
		return this.id + " Not Found";
	}
}
