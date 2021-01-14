package com.issamdrmas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "flight")
public class Flight implements Serializable {

	/**
	 * 
	*/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
  	private String code;
	private String timeArrival;
	private String departureTime;
	private String arrivalSite;
	private String siteDepart;
	private String planeCode;
	private String pilotCode;
	
	public Flight() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(String timeArrival) {
		this.timeArrival = timeArrival;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalSite() {
		return arrivalSite;
	}

	public void setArrivalSite(String arrivalSite) {
		this.arrivalSite = arrivalSite;
	}

	public String getSiteDepart() {
		return siteDepart;
	}

	public void setSiteDepart(String siteDepart) {
		this.siteDepart = siteDepart;
	}

	public String getPlaneCode() {
		return planeCode;
	}

	public void setPlaneCode(String planeCode) {
		this.planeCode = planeCode;
	}

	public String getPilotCode() {
		return pilotCode;
	}

	public void setPilotCode(String pilotCode) {
		this.pilotCode = pilotCode;
	}
    
	


}