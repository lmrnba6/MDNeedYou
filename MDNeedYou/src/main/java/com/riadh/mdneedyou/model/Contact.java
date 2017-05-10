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
@Table(name = "CONTACT")
public class Contact {
	@Id
	@Column(name = "CONTACT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;
	@Column(name = "PHONE_NUMBER")
	private String PHONE_NUMBER;
	@Column(name = "EMAIL")
	private String email;
}
