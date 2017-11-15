package com.riadh.mdneedyou.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.OneTreatmentDAO;
import com.riadh.mdneedyou.model.OneTreatment;

@Repository
public class OneTreatmentDAOImpl implements OneTreatmentDAO {

	private static final Logger logger = LoggerFactory.getLogger(OneTreatmentDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public void add(OneTreatment p) {

		entityManager.persist(p);
		logger.info("OneTreatment saved successfully, OneTreatment Details=" + p);
	}

	@Override
	public void update(OneTreatment p) {

		entityManager.merge(p);
		logger.info("OneTreatment updated successfully, OneTreatment Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OneTreatment> list() {

		List<OneTreatment> OneTreatmentsList = entityManager.createQuery("from OneTreatment").getResultList();
		for (OneTreatment p : OneTreatmentsList) {
			logger.info("OneTreatment List::" + p);
		}
		return OneTreatmentsList;
	}

	@Override
	public OneTreatment getById(Long id) {

		OneTreatment OneTreatment = (OneTreatment) entityManager.find(OneTreatment.class, id);
		logger.info("OneTreatment loaded successfully, OneTreatment details=" + OneTreatment);
		return OneTreatment;
	}

	@Override
	public void remove(Long id) {

		OneTreatment p = (OneTreatment) entityManager.find(OneTreatment.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("OneTreatment deleted successfully, OneTreatment details=" + p);
	}

	public OneTreatment getByName(String OneTreatmentName) {
		//TODO
		return null;
	}
	
	public List<OneTreatment> getByBusiness(Long id) {
		List<OneTreatment> oneTreatmentList = entityManager.createQuery("select r from OneTreatment as r join r.business as b where b.businessId = :id").setParameter("id", id).getResultList();
		return oneTreatmentList;
	}

}
