package com.covisafe.modal;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class IdCard extends User{

	@Size(min = 2, max = 20)
	private String name;
	
	@Past(message = "Invalid date of birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private LocalDate dob;
	
	@NotNull(message = "Gender must be specified")
	private String gender;
	
	@Size(min = 2, max = 80, message = "minimum 2 an maximum 80 characters are allowed")
	private String address;
	
	@Size(min = 2, max = 40)
	private String city;
	
	@Size(min = 2, max = 40)
	private String state;
	
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid  PIN code")
	private String pincode;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private String panNo;

	private String aadharNo;
	
	@JsonIgnore
	@OneToOne
	private Member member;
	
}