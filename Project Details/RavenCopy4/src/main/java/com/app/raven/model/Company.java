package com.app.raven.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Pojo for company details
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Table(name = "company_details")
@NoArgsConstructor 
@AllArgsConstructor
@JsonIgnoreType
public class Company extends BaseEntity {

	@Column(name = "company_name", unique = true)
	private String companyName;
	@Column(name = "website")
	private String website;
	@Column(name = "company_logo")
	private String logo;
	@Column(name = "twitter")
	private String twitter; // to store address of company's twitter page
	@Column(name = "youtube")
	private String youtubechannel;// to store address of youtube channel
	@Column(name = "linkdin")
	private String linkdinPage; // to store address of company linkdin page
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getYoutubechannel() {
		return youtubechannel;
	}
	public void setYoutubechannel(String youtubechannel) {
		this.youtubechannel = youtubechannel;
	}
	public String getLinkdinPage() {
		return linkdinPage;
	}
	public void setLinkdinPage(String linkdinPage) {
		this.linkdinPage = linkdinPage;
	}
	
}
