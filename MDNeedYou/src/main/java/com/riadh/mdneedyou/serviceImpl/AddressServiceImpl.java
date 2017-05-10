package com.riadh.mdneedyou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.AddressDAO;
import com.riadh.mdneedyou.model.Address;
import com.riadh.mdneedyou.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO AddressDAO;

	@Override
	public void add(Address p) {
		this.AddressDAO.add(p);
	}

	@Override
	public void update(Address p) {
		this.AddressDAO.update(p);
	}

	@Override
	public List<Address> list() {
		return this.AddressDAO.list();
	}

	@Override
	public Address getById(Long id) {
		return this.AddressDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.AddressDAO.remove(id);
	}

	@Override
	public Address getByName(String AddressName) {

		return this.AddressDAO.getByName(AddressName);
	}

}
