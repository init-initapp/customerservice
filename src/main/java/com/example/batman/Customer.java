package com.example.batman;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {

	@GeneratedValue
	@Id
	Long id;
	String firstName;
	String lastName;
	String email;
	String streetNumber;
	String streetName;
	String city;
	String state;
	String zipcode;
}
