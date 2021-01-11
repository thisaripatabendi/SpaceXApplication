package com.cloud.SpaceXApplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@Validated
public class MockResponse {
	
	@JsonProperty("status")
	private int status;
	
	@JsonProperty("message")
	private String message;

	public MockResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
