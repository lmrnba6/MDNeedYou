package com.riadh.mdneedyou.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.TreatmentDAO;
import com.riadh.mdneedyou.model.Treatment;

@Repository
public class TreatmentDAOImpl implements TreatmentDAO {

	private static final Logger logger = LoggerFactory.getLogger(TreatmentDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public void add(Treatment p) {

		entityManager.persist(p);
		logger.info("Treatment saved successfully, Treatment Details=" + p);
	}

	@Override
	public void update(Treatment p) {

		entityManager.merge(p);
		logger.info("Treatment updated successfully, Treatment Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Treatment> list() {

		List<Treatment> TreatmentsList = entityManager.createQuery("from Treatment").getResultList();
		for (Treatment p : TreatmentsList) {
			logger.info("Treatment List::" + p);
		}
		return TreatmentsList;
	}

	@Override
	public Treatment getById(Long id) {

		Treatment Treatment = (Treatment) entityManager.find(Treatment.class, id);
		logger.info("Treatment loaded successfully, Treatment details=" + Treatment);
		return Treatment;
	}

	@Override
	public void remove(Long id) {

		Treatment p = (Treatment) entityManager.find(Treatment.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("Treatment deleted successfully, Treatment details=" + p);
	}

	public Treatment getByName(String TreatmentName) {
		//TODO
		return null;
	}

}
