package com.saudrav.currencyexchangeservice.exceptions;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
//@AllArgsConstructor
public class ErrorMapper {
	
	private int statuscode;
	private String errMessage ;
	private Date errTime;
	
	
	public ErrorMapper(int statuscode, String errMessage, Date errTime) {
		super();
		this.statuscode = statuscode;
		this.errMessage = errMessage;
		this.errTime = errTime;
	}
	
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	public Date getErrTime() {
		return errTime;
	}
	public void setErrTime(Date errTime) {
		this.errTime = errTime;
	}
	
	

}
