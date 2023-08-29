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

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "Review")
@NoArgsConstructor 
@AllArgsConstructor
@JsonIgnoreType
public class Reviews extends BaseEntity {
	@Column
	private int ratting;
	@Column
	private String review;
	
	
}
