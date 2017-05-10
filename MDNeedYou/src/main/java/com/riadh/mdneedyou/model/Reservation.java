package com.riadh.mdneedyou.model;

import java.sql.Date;
import java.sql.Time;

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
@Table(name = "RESERVATION")
public class Reservation {
	@Id
	@Column(name = "RESERVATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;
	@Column(name = "RESERVATION_NUMBER")
	private Long reservationNumber;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "TIME")
	private Time time;
	@OneToOne
	@JoinColumn(name = "BUSINESS_ID")
	private Business business;
	@Column(name = "STATUS")
	private String status;
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@Column(name = "COMMENT")
	private String comment;

}
