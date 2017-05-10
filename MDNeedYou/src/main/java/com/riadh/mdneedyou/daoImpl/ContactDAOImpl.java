package com.riadh.mdneedyou.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.ContactDAO;
import com.riadh.mdneedyou.model.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	private static final Logger logger = LoggerFactory.getLogger(ContactDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public void add(Contact p) {

		entityManager.persist(p);
		logger.info("Contact saved successfully, Contact Details=" + p);
	}

	@Override
	public void update(Contact p) {

		entityManager.merge(p);
		logger.info("Contact updated successfully, Contact Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> list() {

		List<Contact> ContactsList = entityManager.createQuery("from Contact").getResultList();
		for (Contact p : ContactsList) {
			logger.info("Contact List::" + p);
		}
		return ContactsList;
	}

	@Override
	public Contact getById(Long id) {

		Contact Contact = (Contact) entityManager.find(Contact.class, id);
		logger.info("Contact loaded successfully, Contact details=" + Contact);
		return Contact;
	}

	@Override
	public void remove(Long id) {

		Contact p = (Contact) entityManager.find(Contact.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("Contact deleted successfully, Contact details=" + p);
	}

	public Contact getByName(String ContactName) {
		//TODO
		return null;
	}

}
