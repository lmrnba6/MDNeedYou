package com.riadh.mdneedyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riadh.mdneedyou.model.User;
import com.riadh.mdneedyou.service.UserService;



@CrossOrigin(origins = {"http://localhost:8080" , "http://localhost:3000"} )
@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
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
	
}
