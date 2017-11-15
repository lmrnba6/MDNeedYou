package com.riadh.mdneedyou.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riadh.mdneedyou.model.Address;
import com.riadh.mdneedyou.model.Availability;
import com.riadh.mdneedyou.model.Business;
import com.riadh.mdneedyou.model.Category;
import com.riadh.mdneedyou.model.Contact;
import com.riadh.mdneedyou.model.Medecin;
import com.riadh.mdneedyou.model.User;
import com.riadh.mdneedyou.model.WorkingDay;
import com.riadh.mdneedyou.service.AddressService;
import com.riadh.mdneedyou.service.AvailabilityService;
import com.riadh.mdneedyou.service.BusinessService;
import com.riadh.mdneedyou.service.CategoryService;
import com.riadh.mdneedyou.service.ContactService;
import com.riadh.mdneedyou.service.MedecinService;
import com.riadh.mdneedyou.service.ReservationService;
import com.riadh.mdneedyou.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:3000", "http://mdneedyou.netlify.com" })
@RestController
@RequestMapping("business")
public class BusinessController {

	@Autowired
	BusinessService businessService;
	@Autowired
	MedecinService medecinService;
	@Autowired
	UserService userService;
	@Autowired
	ReservationService reservationService;
	@Autowired
	AddressService addressService;
	@Autowired
	ContactService contactService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AvailabilityService availabilityService;

	@RequestMapping(value = "{id}")
	public Business getBusiness(@PathVariable Long id) {

		return businessService.getById(id);

	}

	@RequestMapping(value = "/list/{city}")
	public List<Business> listBusiness(@PathVariable String city) {
		return businessService.listByCity(city);

	}

	@RequestMapping(value = "/patients/{id}")
	public List<User> listUser(@PathVariable String id) {
		Business business = businessService.getById(Long.valueOf(id));
		return business.getPatients();

	}

	@RequestMapping(value = "/addPatient")
	public List<User> addPatient(@RequestBody Map<String, Object> post) {
		User patient = new User();
		patient.setName(post.get("patientName").toString());
		patient.setEmail(post.get("patientEmail").toString());
		patient.setPhone(post.get("patientPhone").toString());
		patient.setAge(post.get("patientAge").toString());
		patient.setSex(post.get("patientSex").toString());
		userService.add(patient);
		Business business = businessService.getById(Long.valueOf(post.get("id").toString()));
		business.getPatients().add(patient);
		businessService.update(business);
		return business.getPatients();

	}

	@RequestMapping(value = "/editPatient")
	public List<User> editPatient(@RequestBody Map<String, Object> post) {
		User patient = userService.getById(Long.valueOf(post.get("patientId").toString()));
		patient.setName(post.get("patientName").toString());
		patient.setEmail(post.get("patientEmail").toString());
		patient.setPhone(post.get("patientPhone").toString());
		patient.setAge(post.get("patientAge").toString());
		patient.setSex(post.get("patientSex").toString());;
		userService.update(patient);
		Business business = businessService.getById(Long.valueOf(post.get("id").toString()));
		return business.getPatients();

	}

	@RequestMapping(value = "/deletePatient")
	public List<User> deletePatient(@RequestBody Map<String, Object> post) {
		Business business = businessService.getById(Long.valueOf(post.get("id").toString()));
		List<User> patient = business.getPatients().stream().filter(user -> Long.valueOf(post.get("patientId").toString()) != (user.getUserId()))
				.collect(Collectors.toList());
		business.setPatients(patient);
		businessService.update(business);
		return patient;
	}

	@RequestMapping(value = "medecin/list/{id}")
	public List<Medecin> listMedecin(@PathVariable String id) {
		return medecinService.getByBusiness(Long.valueOf(id));
	}

	@RequestMapping(value = "medecin/add")
	public List<Medecin> addMedecin(@RequestBody Map<String, Object> post) {
		String id = post.get("id").toString();
		String name = post.get("medecinName").toString();
		String description = post.get("medecinDescription").toString();
		Medecin medecin = new Medecin();
		medecin.setDescription(description);
		medecin.setName(name);
		Business business = businessService.getById(Long.valueOf(id));
		medecin.setBusiness(business);
		medecinService.add(medecin);
		return medecinService.getByBusiness(Long.valueOf(id));
	}

	@RequestMapping(value = "medecin/delete")
	public List<Medecin> deleteMedecin(@RequestBody Map<String, Object> post) {
		String id = post.get("id").toString();
		String medecinId = post.get("medecinId").toString();
		medecinService.remove(Long.valueOf(medecinId));
		return medecinService.getByBusiness(Long.valueOf(id));
	}

	@RequestMapping(value = "medecin/update")
	public List<Medecin> updateMedecin(@RequestBody Map<String, Object> post) {
		String id = post.get("id").toString();
		String medecinId = post.get("medecinId").toString();
		String name = post.get("medecinName").toString();
		String description = post.get("medecinDescription").toString();
		Medecin medecin = medecinService.getById(Long.valueOf(medecinId));
		medecin.setDescription(description);
		medecin.setName(name);
		medecinService.update(medecin);
		return medecinService.getByBusiness(Long.valueOf(id));
	}

	@RequestMapping(value = "/list/doctor/{name}")
	public List<Business> listBusinessByName(@PathVariable String name) {
		List<Business> list = new ArrayList<>();
		Business business = businessService.getByName(name);
		list.add(business);
		return list;
	}

	@RequestMapping(value = "/remove/{id}")
	public List<Business> removeBusiness(@PathVariable Long id) {

		businessService.remove(id);
		return businessService.list();
	}

	@RequestMapping(value = "/filterList")
	public List<Business> filterCities(@RequestBody Map<String, Object> post) throws ServletException {
		List<Business> list = businessService.listByCity(post.get("city").toString());
		List<Business> categoryList = new ArrayList<>();
		List<Business> sexList = new ArrayList<>();
		List<Business> nameList = new ArrayList<>();
		List<String> filter = (ArrayList<String>) post.get("filter");
		List<String> sex = (ArrayList<String>) post.get("sex");
		String name = (String) post.get("name");
		// filter by categories
		if (filter.isEmpty()) {
			categoryList = list;
		} else {
			for (Business business : list) {
				for (String f : filter) {
					if (f.equals(business.getCategory().getName())) {
						categoryList.add(business);
					}
				}
			}
		}
		if (!sex.isEmpty()) {
			for (Business business : categoryList) {
				for (String s : sex) {
					if (business.getUser().getSex().equals(s)) {
						sexList.add(business);
					}
				}
			}
			categoryList = sexList;
		}
		if (!name.isEmpty()) {
			for (Business business : categoryList) {
				if (business.getName().startsWith(name)) {
					nameList.add(business);
				}
			}
			categoryList = nameList;
		}

		return categoryList;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update")
	public Business update(@RequestBody Map<String, Object> post) throws ServletException {
		boolean photo = (boolean) post.get("photoInfo");
		boolean personal = (boolean) post.get("personalInfo");
		boolean businessInfo = (boolean) post.get("businessInfo");
		boolean working = (boolean) post.get("workingInfo");
		boolean list = (boolean) post.get("listInfo");
		boolean calendar = (boolean) post.get("calendarInfo");
		Long id = Long.valueOf(post.get("id").toString());
		Business business = businessService.getById(id);
		User user = business.getUser();
		Address address = business.getAddress();
		Contact contact = business.getContact();
		Category category = business.getCategory();
		Availability availability = business.getAvailability();

		if (photo) {
			business.setPhoto(post.get("avatarURL").toString());
		} else if (personal) {
			user.setName(post.get("ownerName").toString());
			user.setEmail(post.get("ownerEmail").toString());
			user.setPhone(post.get("ownerPhone").toString());
			business.setUser(user);
		} else if (businessInfo) {
			business.setName(post.get("name").toString());
			business.setDescription(post.get("description").toString());
			business.setPassword(post.get("password").toString());
			business.setWebsite(post.get("webSite").toString());
			address.setCity(post.get("city").toString().replaceAll("\\s", "").toLowerCase());
			address.setProvince(post.get("state").toString());
			address.setStreetName(post.get("streetName").toString());
			address.setStreetNumber(Long.valueOf(
					post.get("streetNumber").toString().isEmpty() ? "0" : post.get("streetNumber").toString()));
			address.setZipCode(post.get("zip").toString());
			addressService.update(address);
			contact.setEmail(post.get("email").toString());
			contact.setPhone(post.get("phone").toString());
			contactService.update(contact);
			category.setName(post.get("category").toString());
			categoryService.update(category);
			business.setCategory(category);
			business.setContact(contact);
			business.setAddress(address);
		} else if (working) {
			for (Map<String, Object> day : (List<Map<String, Object>>) post.get("availability")) {
				for (WorkingDay av : availability.getDays()) {
					if (day.get("day").equals(av.getDay())) {
						av.setClosing((String) day.get("closing"));
						av.setOpening((String) day.get("opening"));
						if (day.get("working").equals(true) || day.get("working").equals("true"))
							av.setWorking(true);
						else
							av.setWorking(false);
					}
				}
			}
			availability.setAppointmentDuration(Integer.valueOf((String) post.get("appDuration")));
			availabilityService.update(availability);
			business.setAvailability(availability);

		} else if (list) {

		} else if (calendar) {

		}

		businessService.update(business);
		return business;
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

		token = Jwts.builder().claim("business", b).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		return b;

	}

}
