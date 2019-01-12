package com.example.sbjwt.controller;

public class User {
	
	private String nom;
	private String token;
	
	

	public User(String nom, String token) {
		super();
		this.nom = nom;
		this.token = token;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
