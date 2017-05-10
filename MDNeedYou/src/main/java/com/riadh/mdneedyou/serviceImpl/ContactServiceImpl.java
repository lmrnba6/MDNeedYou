package com.riadh.mdneedyou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.ContactDAO;
import com.riadh.mdneedyou.model.Contact;
import com.riadh.mdneedyou.service.ContactService;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO ContactDAO;

	@Override
	public void add(Contact p) {
		this.ContactDAO.add(p);
	}

	@Override
	public void update(Contact p) {
		this.ContactDAO.update(p);
	}

	@Override
	public List<Contact> list() {
		return this.ContactDAO.list();
	}

	@Override
	public Contact getById(Long id) {
		return this.ContactDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.ContactDAO.remove(id);
	}

	@Override
	public Contact getByName(String ContactName) {

		return this.ContactDAO.getByName(ContactName);
	}

}
