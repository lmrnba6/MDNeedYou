package com.riadh.mdneedyou.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.BusinessDAO;
import com.riadh.mdneedyou.model.Business;
import com.riadh.mdneedyou.util.SecurePassword;

@Repository
public class BusinessDAOImpl implements BusinessDAO {

	private static final Logger logger = LoggerFactory.getLogger(BusinessDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public void add(Business p) {

		entityManager.persist(p);
		logger.info("Business saved successfully, Business Details=" + p);
	}

	@Override
	public void update(Business p) {

		entityManager.merge(p);
		logger.info("Business updated successfully, Business Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Business> list() {

		List<Business> BusinesssList = entityManager.createQuery("from Business").getResultList();
		for (Business p : BusinesssList) {
			logger.info("Business List::" + p);
		}
		return BusinesssList;
	}

	@Override
	public Business getById(Long id) {

		Business Business = (Business) entityManager.find(Business.class, id);
		logger.info("Business loaded successfully, Business details=" + Business);
		return Business;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkLogin(String email, String pass) {

		boolean BusinessFound = false;
		pass = SecurePassword.getSecurePassword(pass);
		// Query using Hibernate Query Language
		String SQL_QUERY = " from Business as o where o.email= '" + email + "' and o.password= '" + pass
				+ "'";
		List<Business> list = entityManager.createQuery(SQL_QUERY).getResultList();

		if ((list != null) && (list.size() > 0)) {
			BusinessFound = true;
		}

		return BusinessFound;
	}

	@Override
	public void remove(Long id) {

		Business p = (Business) entityManager.find(Business.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("Business deleted successfully, Business details=" + p);
	}

	public Business getByName(String BusinessName) {
		//TODO
		return null;
	}

}
