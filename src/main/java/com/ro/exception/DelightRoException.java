package com.ro.exception;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class DelightRoException  extends Exception{
	private static final long serialVersionUID = 1L;
	private String code;

	public DelightRoException(String message) {
		super(message);
		this.code="";
	}
	public DelightRoException(String code,String message) {
		super(message);
		this.code="";
	}	
}
