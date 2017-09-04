package com.riadh.mdneedyou.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.MedecinDAO;
import com.riadh.mdneedyou.model.Medecin;

@Repository
public class MedecinDAOImpl implements MedecinDAO {

	private static final Logger logger = LoggerFactory.getLogger(MedecinDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public void add(Medecin p) {

		entityManager.persist(p);
		logger.info("Medecin saved successfully, Medecin Details=" + p);
	}

	@Override
	public void update(Medecin p) {

		entityManager.merge(p);
		logger.info("Medecin updated successfully, Medecin Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medecin> list() {

		List<Medecin> MedecinsList = entityManager.createQuery("from Medecin").getResultList();
		for (Medecin p : MedecinsList) {
			logger.info("Medecin List::" + p);
		}
		return MedecinsList;
	}

	@Override
	public Medecin getById(Long id) {

		Medecin Medecin = (Medecin) entityManager.find(Medecin.class, id);
		logger.info("Medecin loaded successfully, Medecin details=" + Medecin);
		return Medecin;
	}

	@Override
	public void remove(Long id) {

		Medecin p = (Medecin) entityManager.find(Medecin.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("Medecin deleted successfully, Medecin details=" + p);
	}

	public Medecin getByName(String MedecinName) {
		//TODO
		return null;
	}
	
	public List<Medecin> getByBusiness(Long id) {
		List<Medecin> medecinList = entityManager.createQuery("select r from Medecin as r join r.business as b where b.businessId = :id").setParameter("id", id).getResultList();
		return medecinList;
	}

}
