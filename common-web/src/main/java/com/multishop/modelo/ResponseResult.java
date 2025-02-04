package com.multishop.modelo;

import java.security.Timestamp;

public class ResponseResult {
	
	private boolean success;
	private Timestamp challenge_ts;
	private String hostname;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Timestamp getChallenge_ts() {
		return challenge_ts;
	}
	public void setChallenge_ts(Timestamp challenge_ts) {
		this.challenge_ts = challenge_ts;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	
	
	

}
