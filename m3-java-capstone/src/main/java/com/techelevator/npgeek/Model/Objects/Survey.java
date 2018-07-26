package com.techelevator.npgeek.Model.Objects;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	@Size(min = 3, max = 5, message = "Please select a park")
	String parkCode;
	
	@NotBlank(message = "Please enter a valid email address")
	@Email(message="Please enter a valid email address")
	String email;
	
	@Size(min=2, max =2, message = "Please select a state")
	String state;
	
	@NotBlank(message = "Please select an activity level")
	String activityLevel;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
	
}
