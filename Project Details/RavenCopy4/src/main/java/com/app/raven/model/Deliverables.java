package com.app.raven.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity // This annotation tells the compiler that what follows is a part of the entity
@Data // The lombok lib. provide Getters, Setters, Parameterised, parameterless
		// constructor, hashcode equals and toString method
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreType
@Table(name = "Deliverables")
public class Deliverables extends BaseEntity {
	@Column(name = "banner_image")
	private String bannerImage;

	@Column(name = "poster")
	private String poster;
	@Column(name = "ad_location")
	private String location;

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
