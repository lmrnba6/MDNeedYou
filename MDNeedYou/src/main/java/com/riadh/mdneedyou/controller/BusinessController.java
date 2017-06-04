package com.riadh.mdneedyou.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riadh.mdneedyou.model.Business;
import com.riadh.mdneedyou.service.BusinessService;

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

	@RequestMapping(value = "/login")
	public Business login(@RequestBody Map<String, Object> post) {
		Business b = businessService.login(post.get("email").toString(), post.get("password").toString());
		if (b != null)
			return b;
		else
			throw new IllegalArgumentException("business not found");

	}

}
