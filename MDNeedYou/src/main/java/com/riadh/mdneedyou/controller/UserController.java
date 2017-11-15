package com.riadh.mdneedyou.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riadh.mdneedyou.model.Business;
import com.riadh.mdneedyou.model.Medecin;
import com.riadh.mdneedyou.model.OneTreatment;
import com.riadh.mdneedyou.model.Treatment;
import com.riadh.mdneedyou.model.User;
import com.riadh.mdneedyou.service.BusinessService;
import com.riadh.mdneedyou.service.MedecinService;
import com.riadh.mdneedyou.service.OneTreatmentService;
import com.riadh.mdneedyou.service.TreatmentService;
import com.riadh.mdneedyou.service.UserService;



@CrossOrigin(origins = {"http://localhost:8080" , "http://localhost:3000", "http://localhost:4200", "http://mdneedyou.netlify.com"} )
@RestController
@RequestMapping("patient")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MedecinService medecinService;
	
	@Autowired
	BusinessService businessService;
	
	@Autowired
	OneTreatmentService oneTreatmentService;
	
	@Autowired
	TreatmentService treatmentService;
	
	@RequestMapping(value="{id}")
	public User getUser(@PathVariable Long id){
		
		return userService.getById(id);
		
	}
	
	@RequestMapping(value="/list")
	public List<User> listUser(){
		
		return userService.list();
		
	}

	
	@RequestMapping(value="/remove/{id}")
	public List<User> removeUser(@PathVariable Long id){
		userService.remove(id);
		return userService.list();
	}
	
	@RequestMapping(value="/saveTreatment")
	public List<Treatment> saveTreatment(@RequestBody Map<String, Object> post){
		Business business = businessService.getById(Long.valueOf(post.get("id").toString()));
		List<OneTreatment> treatmentList = new ArrayList<>();
		List<Map<String, Object>> treatments = (List<Map<String, Object>>) post.get("medecinForTreatment");
		treatments.forEach(treat -> {
			OneTreatment oneTreatment = new OneTreatment();
			Map<String, Object> m = (Map<String, Object>) treat.get("medecin"); 
			Medecin medecin = medecinService.getById(Long.valueOf(m.get("medecinId").toString()));
			oneTreatment.setMedecin(medecin);
			oneTreatment.setDescription(treat.get("description").toString());
			treatmentList.add(oneTreatment);
			oneTreatmentService.add(oneTreatment);
		});
		Treatment treatment = new Treatment();
		treatment.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		treatment.setDescription(post.get("note").toString());
		treatment.setMedecins(treatmentList);
		User user = userService.getById(Long.valueOf(post.get("patientId").toString()));
		treatment.setUser(user);
		treatmentService.add(treatment);
		return treatmentService.list();
	}
	
	
	
}
