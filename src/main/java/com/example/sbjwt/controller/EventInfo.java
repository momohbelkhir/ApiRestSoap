package com.example.sbjwt.controller;

public class EventInfo {
	private String dateevent;
	private String objetvent;
	private String lieuevent;
	private String hdebvent;
	private String hfinvent;
	private String struserid;
	
	
	public EventInfo(String dateevent, String objetvent, String lieuevent, String hdebvent, String hfinvent,
			String struserid) {
		super();
		this.dateevent = dateevent;
		this.objetvent = objetvent;
		this.lieuevent = lieuevent;
		this.hdebvent = hdebvent;
		this.hfinvent = hfinvent;
		this.struserid = struserid;
	}
	
	
	public String getDateevent() {
		return dateevent;
	}
	public void setDateevent(String dateevent) {
		this.dateevent = dateevent;
	}
	public String getObjetvent() {
		return objetvent;
	}
	public void setObjetvent(String objetvent) {
		this.objetvent = objetvent;
	}
	public String getLieuevent() {
		return lieuevent;
	}
	public void setLieuevent(String lieuevent) {
		this.lieuevent = lieuevent;
	}
	public String getHdebvent() {
		return hdebvent;
	}
	public void setHdebvent(String hdebvent) {
		this.hdebvent = hdebvent;
	}
	public String getHfinvent() {
		return hfinvent;
	}
	public void setHfinvent(String hfinvent) {
		this.hfinvent = hfinvent;
	}
	public String getStruserid() {
		return struserid;
	}
	public void setStruserid(String struserid) {
		this.struserid = struserid;
	}
	
	

}
