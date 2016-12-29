package com.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "carpool")
@DiscriminatorValue("waze")
public class Waze extends CarPool {

	private String ridePreferences;
	private String feedback;

	public Waze(String pickUpLocation, String destination, double price, String ridePreferences, String feedback) {
		super(pickUpLocation, destination, price);
		this.ridePreferences = ridePreferences;
		this.feedback = feedback;
	}

	public String getRidePreferences() {
		return ridePreferences;
	}

	public void setRidePreferences(String ridePreferences) {
		this.ridePreferences = ridePreferences;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
