package com.riadh.mdneedyou.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riadh.mdneedyou.model.Business;
import com.riadh.mdneedyou.model.Reservation;
import com.riadh.mdneedyou.model.User;
import com.riadh.mdneedyou.service.BusinessService;
import com.riadh.mdneedyou.service.ReservationService;
import com.riadh.mdneedyou.service.UserService;
import com.riadh.mdneedyou.util.Email;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000" })
@RestController
@RequestMapping("reservation")
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@Autowired
	BusinessService businessService;
	
	@Autowired
	UserService userService;
	

	@RequestMapping(value = "/schedule")
	public Reservation schedule(@RequestBody Map<String, Object> post) throws ServletException, AddressException, MessagingException {
		String id =String.valueOf(post.get("id"));
		String date = (String) post.get("date");
		String name = (String) post.get("name");
		String email = (String) post.get("email");
		String phone = (String) post.get("phone");
		String message = (String) post.get("message");
		String time = (String) post.get("time");
		Reservation reservation = new Reservation();
		Business business = businessService.getById(Long.valueOf(id));
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPhone(phone);
		userService.add(user);
		reservation.setBusiness(business);
		reservation.setComment(message);
		reservation.setDate(java.sql.Date.valueOf(date));
		reservation.setReservationNumber(new java.util.Date().getTime());
		reservation.setTime(Time.valueOf(time+":00"));
		reservation.setStatus("");
		reservation.setUser(user);
		reservationService.add(reservation);
		Email.generateAndSendEmail(email, business.getName()+" Appointment", "TODO");
		return reservation;
	}

	
	@RequestMapping(value = "/hours")
	public List<Time> getHours(@RequestBody Map<String, Object> post) throws ServletException {
		String id =String.valueOf(post.get("id"));
		String date = (String) post.get("date");
		List<Reservation> list = reservationService.getByDate(java.sql.Date.valueOf(date), Long.valueOf(id));
		List<Time> listFiltered = new ArrayList<>();
		for(Reservation f : list){
			listFiltered.add(f.getTime());
		}
		return listFiltered;
	}
		
}
