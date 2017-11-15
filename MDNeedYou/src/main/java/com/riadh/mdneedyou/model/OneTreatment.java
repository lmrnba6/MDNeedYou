package com.riadh.mdneedyou.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ONE_TREATMENT")
public class OneTreatment {
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "ONE_TREATMENT_ID")
	private Long id;
	@Column(name = "DESCRIPTION")
	private String description;
	@OneToOne
	@JoinColumn(name = "MEDECIN_ID")
	private Medecin medecin;

}
