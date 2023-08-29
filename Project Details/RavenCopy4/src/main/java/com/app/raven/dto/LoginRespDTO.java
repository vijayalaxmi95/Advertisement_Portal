package com.app.raven.dto;

import java.time.LocalDate;

import com.app.raven.model.PackageDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRespDTO {	
	
	private String firstName;	
	private String lastName;	
	private LocalDate packageStartDate;
	private double packagePricing;		
	private PackageDetails packageName;
	
	
}
