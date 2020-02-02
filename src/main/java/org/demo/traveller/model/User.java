package org.demo.traveller.model;

public class User {
	Long id;
	String token;
	String userNAme;
	String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserNAme() {
		return userNAme;
	}
	public void setUserNAme(String userNAme) {
		this.userNAme = userNAme;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", token=" + token + ", userNAme=" + userNAme + ", password=" + password + "]";
	}
}
