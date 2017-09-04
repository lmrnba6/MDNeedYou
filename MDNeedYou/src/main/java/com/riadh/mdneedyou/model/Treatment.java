package com.riadh.mdneedyou.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "TREATMENT")
public class Treatment
{
    @Id
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name = "TREATMENT_ID")
    private Long  treatementId;
    @Column(name = "TIME")
	private String time;
    @Column(name = "DESCRIPTION")
	private String description;
    @ElementCollection
	private List<String> medecins;

}
