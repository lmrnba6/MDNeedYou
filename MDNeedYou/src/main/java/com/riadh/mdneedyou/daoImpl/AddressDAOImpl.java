package com.riadh.mdneedyou.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.AddressDAO;
import com.riadh.mdneedyou.model.Address;

@Repository
public class AddressDAOImpl implements AddressDAO {

	private static final Logger logger = LoggerFactory.getLogger(AddressDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public void add(Address p) {

		entityManager.persist(p);
		logger.info("Address saved successfully, Address Details=" + p);
	}

	@Override
	public void update(Address p) {

		entityManager.merge(p);
		logger.info("Address updated successfully, Address Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> list() {

		List<Address> AddresssList = entityManager.createQuery("from Address").getResultList();
		for (Address p : AddresssList) {
			logger.info("Address List::" + p);
		}
		return AddresssList;
	}

	@Override
	public Address getById(Long id) {

		Address Address = (Address) entityManager.find(Address.class, id);
		logger.info("Address loaded successfully, Address details=" + Address);
		return Address;
	}

	@Override
	public void remove(Long id) {

		Address p = (Address) entityManager.find(Address.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("Address deleted successfully, Address details=" + p);
	}

	public Address getByName(String AddressName) {
		//TODO
		return null;
	}

}
