package com.vodafone.problems.rewards.response;

public class ServiceResponse {
	protected String message;
	protected boolean error;

	public ServiceResponse() {
	}

	public ServiceResponse(String message) {
		this.setMessage(message);
		this.setError(false);
	}

	public ServiceResponse(String message, boolean error) {
		this.setMessage(message);
		this.setError(error);
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return this.error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
