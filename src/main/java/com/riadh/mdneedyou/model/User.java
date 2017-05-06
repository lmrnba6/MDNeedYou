package com.riadh.mdneedyou.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "GENDER")
	private String Gender;
	@Column(name = "MOBILE")
	private Long mobile;
	@Column(name = "CREDITCARD")
	private Long creditCard;
	@Column(name = "HOMEPHONE")
	private Long homePhone;
	@Column(name = "BLOCK")
	private boolean block;
	@Column(name = "LEVEL")
	private String level;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "ENTRYDATE")
	private Date entryDate;
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "BALANCE")
	private Double balance;
	@Column(name = "CITY")
	private String city;
	@Column(name = "ZIP")
	private String zip;
	@Column(name = "STATE")
	private String state;


}
