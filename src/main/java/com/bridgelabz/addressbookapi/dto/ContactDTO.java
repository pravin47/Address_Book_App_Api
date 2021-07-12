package com.bridgelabz.addressbookapi.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ContactDTO 
{
	@Pattern(regexp =  "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid name")
	private String firstname;
	
	@NotBlank(message = "lastname should not be empty")
	private String lastname;
	
	@NotEmpty(message = "Mobile number cannot be null")
	private String mobilenumber;
	
	@NotEmpty(message = "Email Id cannot be null")
	private String emailid;
	
	@NotEmpty(message = "Address cannot be null")	
	private List<String> address;
	
	@NotEmpty(message = "City cannot be null")	
	private String city;
	
	@NotEmpty(message = "PinCode cannot be null")	
	private String pinCode;

	public Object getLastname() {
	
		return null;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}