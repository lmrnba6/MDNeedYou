package com.riadh.mdneedyou.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "AVAILABILITY")
public class Availability {
	@Id
	@Column(name = "AVAILABILITY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long availabilityId;
	
	@OneToMany
	private List<WorkingDay> days;

}
