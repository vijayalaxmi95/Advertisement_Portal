package com.app.raven.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // This annotation tells the compiler that what follows is a part of the entity
@Data // The lombok lib. provide Getters, Setters, Parameterised, parameterless
		// constructor, hashcode equals and toString method
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer") // table annotation overriding the name of table to add a suitable name in
@JsonIgnoreType						// database
public class Customer extends BaseEntity {
	@Column(length = 50) // length of the email is fixed
	private String email; // Email field not null is a necessary fields and is used to login

	@Column(length = 16) // Password has a limit on the wordcount
	private String password; // Password is a notnull fiels and is used to log in the user
	
	@Column(length=20)
	private String Fname;
	
	@Column(length=20)
	private String LName;

	@Column(length = 14) // mobile number is a necessary field and has a limit of 14 characters
	private String mobileNo; // Ex: +91-9525478562

	@Column
	private String address; // Address is the address of the company which the customer belong to.

	@Column
	private LocalDate packageStartDate; // This field is updated when the package is bought

	@Column
	private LocalDate packageEndDate; // This field is updated when the package is bought and tells when the package
										// will end, Calculated as packageStartDate + validity<<<<<<< HEAD
	@Column
	private String role;
	
	@ManyToOne(cascade = CascadeType.ALL) // The connection between the packages and customer Many to one as one
											// customer will buy 1 package but package can have many customers
//	@JsonManagedReference
	//@JsonIgnore
	@JoinColumn(name = "package_id")
	@ToString.Exclude // This will Exclude the toString method
	private PackageDetails pack; // this will map to the package that the customer will purchase

//	@JsonBackReference
	@ToString.Exclude
	@OneToMany(mappedBy = "ownerCust") // the product is mapped as one to many as 1 customer can advertise many
										// products
	private List<Product> prod = new ArrayList<Product>(); // List of the products the customer will advertise

	@ToString.Exclude
	@OneToOne(cascade = CascadeType.ALL) // the company with which the custome is affileated is mapped 1 to 1 as 1
											// customer belong to 1 company
	@JoinColumn(name = "company_id")
	private Company compDet; // Details of the company are mapped here
	
	@ToString.Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id") // ForigenKey of the bill table
	private Bill orderDetails; // Details of the bill are mapped here in a One to One unidirectional relation 

	/*
	 * this is filling the emty list and update the relation
	 */
	public Customer assignProd(Product pro) {
		this.prod.add(pro);
		return this;
	}

	/*
	 * This is a method to remove product from the list
	 */
	public Customer removeProd(Product pro) {
		this.prod.remove(pro);
		return this;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getPackageStartDate() {
		return packageStartDate;
	}

	public void setPackageStartDate(LocalDate packageStartDate) {
		this.packageStartDate = packageStartDate;
	}

	public LocalDate getPackageEndDate() {
		return packageEndDate;
	}

	public void setPackageEndDate(LocalDate packageEndDate) {
		this.packageEndDate = packageEndDate;
	}

	public PackageDetails getPack() {
		return pack;
	}

	public void setPack(PackageDetails pack) {
		this.pack = pack;
	}

	public List<Product> getProd() {
		return prod;
	}

	public void setProd(List<Product> prod) {
		this.prod = prod;
	}

	public Company getCompDet() {
		return compDet;
	}

	public void setCompDet(Company compDet) {
		this.compDet = compDet;
	}

	public Bill getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Bill orderDetails) {
		this.orderDetails = orderDetails;
	}

	

}
