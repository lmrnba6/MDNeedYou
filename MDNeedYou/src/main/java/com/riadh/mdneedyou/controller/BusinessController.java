package com.riadh.mdneedyou.controller;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riadh.mdneedyou.model.Business;
import com.riadh.mdneedyou.service.BusinessService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000" })
@RestController
@RequestMapping("business")
public class BusinessController {

	@Autowired
	BusinessService businessService;

	@RequestMapping(value = "{id}")
	public Business getBusiness(@PathVariable Long id) {

		return businessService.getById(id);

	}

	@RequestMapping(value = "/list/{city}")
	public List<Business> listBusiness(@PathVariable String city) {

		System.out.println(city);
		return businessService.listByCity(city);

	}

	@RequestMapping(value = "/remove/{id}")
	public List<Business> removeBusiness(@PathVariable Long id) {

		businessService.remove(id);
		return businessService.list();
	}
	
	@RequestMapping(value = "/filterList")
	public List<Business> filterCities(@RequestBody Map<String, Object> post) throws ServletException {
		List<Business> list = businessService.listByCity(post.get("city").toString());
		List<Business> listFiltered = new ArrayList<>();
		List<String> filter =  (ArrayList<String>) post.get("filter");
		for(String f : filter){
			for(Business b : list){
				if(f.equals(b.getCategory().getName()))
					listFiltered.add(b);	
			}
		}

		return listFiltered;
	}
		

	@RequestMapping(value = "/login")
	public Business login(@RequestBody Map<String, Object> post) throws ServletException {
		
		String token = "";
		String pwd = (String) post.get("password");
		String email = (String) post.get("email");

	    if (email == null || pwd == null) {
	        throw new ServletException("Please fill in username and password");
	    }

	    Business b = businessService.login(post.get("email").toString(), post.get("password").toString());
	    if (b == null)
	    	throw new ServletException("business not found");

	    token = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
	            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	    return b;

	}

}
