package com.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "carpool")
@DiscriminatorValue("scoop")
public class Scoop extends CarPool {

	private boolean CommunityView;
	private String chooseDriver;

	public Scoop(String pickUpLocation, String destination, double price, boolean communityView, String chooseDriver) {
		super(pickUpLocation, destination, price);
		CommunityView = communityView;
		this.chooseDriver = chooseDriver;
	}

	public boolean getCommunityView() {
		return CommunityView;
	}

	public void setCommunityView(boolean communityView) {
		CommunityView = communityView;
	}

	public String getChooseDriver() {
		return chooseDriver;
	}

	public void setChooseDriver(String chooseDriver) {
		this.chooseDriver = chooseDriver;
	}

}
