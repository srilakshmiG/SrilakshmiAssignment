package com.singleTable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/*
 * SingleTable
 */
@Entity
@Table(name = "carpool")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pool_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("carpool")
public class CarPool {
	@Id
	@GeneratedValue
	@Column(name = "pool_id")
	private int poolId;
	private String pickUpLocation;
	private String destination;
	private double price;

	public CarPool(String pickUpLocation, String destination, double price) {
		super();
		this.pickUpLocation = pickUpLocation;
		this.destination = destination;
		this.price = price;
	}

	public int getPoolId() {
		return poolId;
	}

	public void setPoolId(int poolId) {
		this.poolId = poolId;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
