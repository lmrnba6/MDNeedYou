package com.riadh.mdneedyou.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "BUSINESS")
public class Business {
	@Id
	@Column(name = "BUSINESS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessId;
	@Column(name = "NAME")
	private String name;
	@OneToOne
	@JoinColumn(name = "ADDRESS")
	private Address address;
	@OneToOne
	@JoinColumn(name = "CONTACT")
	private Contact contact;
	@OneToOne
	@JoinColumn(name = "AVAILABILITY")
	private Availability Availability;
	@Column(name = "DESCRIPTION")
	private String description;
	@OneToOne
	@JoinColumn(name = "CATEGORY")
	private Category category;
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@Column(name = "IMAGE")
	private String image;
	@Column(name = "WEBSITE")
	private String website;
	@Column(name = "PASSWORD")
	private String password;

}
