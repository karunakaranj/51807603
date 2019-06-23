package com.usecase.personalloan.exception;

public class OXBankingException extends Exception{
	public OXBankingException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}

	private String exceptionMessage;

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	

}
