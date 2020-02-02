package org.demo.traveller.model;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class Budget {

	Long id;
	String country;
	String userId;
	ZonedDateTime dateTaken;
	Integer roundTrips;
	Integer leftover;
	
	Map<String, String> countryBudget = new HashMap<>();
	
	public Budget(String country, Integer roundTrips, Integer leftover) {
		super();
		dateTaken = ZonedDateTime.now();
		this.country = country;
		this.roundTrips = roundTrips;
		this.leftover = leftover;
	}

	public Budget() {
		// TODO Auto-generated constructor stub
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getRoundTrips() {
		return roundTrips;
	}

	public void setRoundTrips(Integer roundTrips) {
		this.roundTrips = roundTrips;
	}

	public Map<String, String> getCountryBudget() {
		return countryBudget;
	}

	public Integer getLeftover() {
		return leftover;
	}

	public void setLeftover(Integer leftover) {
		this.leftover = leftover;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Budget [country=" + country + ", userId=" + userId + ", dateTaken=" + dateTaken + ", roundTrips="
				+ roundTrips + ", countryBudget=" + countryBudget + "]";
	}
	
	
}
