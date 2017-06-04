package com.riadh.mdneedyou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.BusinessDAO;
import com.riadh.mdneedyou.model.Business;
import com.riadh.mdneedyou.service.BusinessService;

@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessDAO BusinessDAO;

	@Override
	public void add(Business p) {
		this.BusinessDAO.add(p);
	}

	@Override
	public void update(Business p) {
		this.BusinessDAO.update(p);
	}

	@Override
	public List<Business> list() {
		return this.BusinessDAO.list();
	}

	@Override
	public Business getById(Long id) {
		return this.BusinessDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.BusinessDAO.remove(id);
	}
	
	@Override
	public List<Business> listByCity(String city) {
		return this.BusinessDAO.listByCity(city);
	}

	@Override
	public Business getByName(String BusinessName) {

		return this.BusinessDAO.getByName(BusinessName);
	}
	
	@Override
	public Business login (String email, String password) {

		return this.BusinessDAO.login(email, password);
	}

}
