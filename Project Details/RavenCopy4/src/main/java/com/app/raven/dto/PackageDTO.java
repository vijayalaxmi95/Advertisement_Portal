package com.app.raven.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PackageDTO {

	
	private String PName;						 // name = "PACKAGE_NAME" -> Specifies Column Name in Database Table
	
	// name = "PACKAGE_COST" -> Specifies Column Name in Database Table
	private double PCost;
	
	private int PValidity;
	
	
	private String pLogo; // We will store the banner of the image here


	public String getPName() {
		return PName;
	}


	public void setPName(String pName) {
		PName = pName;
	}


	public double getPCost() {
		return PCost;
	}


	public void setPCost(double pCost) {
		PCost = pCost;
	}


	public int getPValidity() {
		return PValidity;
	}


	public void setPValidity(int pValidity) {
		PValidity = pValidity;
	}


	public String getpLogo() {
		return pLogo;
	}


	public void setpLogo(String pLogo) {
		this.pLogo = pLogo;
	}
	
}
