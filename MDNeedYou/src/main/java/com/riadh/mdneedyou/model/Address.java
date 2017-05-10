package com.riadh.mdneedyou.model;

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
@Table(name = "ADDRESS")
public class Address {
	@Id
	@Column(name = "ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	@Column(name = "STREET_NUMBER")
	private Long streetNumber;
	@Column(name = "STREET_NAME")
	private String streetName;
	@Column(name = "PROVINCE")
	private String province;
	@Column(name = "ZIP_CODE")
	private String zipCode;
	@Column(name = "COUNTRY")
	private String country;
}
