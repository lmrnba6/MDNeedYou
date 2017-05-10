package com.riadh.mdneedyou.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.AvailabilityDAO;
import com.riadh.mdneedyou.model.Availability;

@Repository
public class AvailabilityDAOImpl implements AvailabilityDAO {

	private static final Logger logger = LoggerFactory.getLogger(AvailabilityDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public void add(Availability p) {

		entityManager.persist(p);
		logger.info("Availability saved successfully, Availability Details=" + p);
	}

	@Override
	public void update(Availability p) {

		entityManager.merge(p);
		logger.info("Availability updated successfully, Availability Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Availability> list() {

		List<Availability> AvailabilitysList = entityManager.createQuery("from Availability").getResultList();
		for (Availability p : AvailabilitysList) {
			logger.info("Availability List::" + p);
		}
		return AvailabilitysList;
	}

	@Override
	public Availability getById(Long id) {

		Availability Availability = (Availability) entityManager.find(Availability.class, id);
		logger.info("Availability loaded successfully, Availability details=" + Availability);
		return Availability;
	}

	@Override
	public void remove(Long id) {

		Availability p = (Availability) entityManager.find(Availability.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("Availability deleted successfully, Availability details=" + p);
	}

	public Availability getByName(String AvailabilityName) {
		//TODO
		return null;
	}

}
