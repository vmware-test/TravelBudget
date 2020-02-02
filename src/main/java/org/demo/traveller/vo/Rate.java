package org.demo.traveller.vo;

import java.util.Map;

public class Rate {
	String base;
	String date;
	Map<String, Double> rates;
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Map<String, Double> getRates() {
		return rates;
	}
	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
	@Override
	public String toString() {
		return "Rate [base=" + base + ", date=" + date + ", rates=" + rates + "]";
	}
	
	
}
