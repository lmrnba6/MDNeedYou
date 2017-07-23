package com.riadh.mdneedyou.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.WorkingDayDAO;
import com.riadh.mdneedyou.model.WorkingDay;

@Repository
public class WorkingDaysDAOImpl implements WorkingDayDAO {

	private static final Logger logger = LoggerFactory.getLogger(WorkingDaysDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public void add(WorkingDay p) {

		entityManager.persist(p);
		logger.info("WorkingDay saved successfully, WorkingDay Details=" + p);
	}

	@Override
	public void update(WorkingDay p) {

		entityManager.merge(p);
		logger.info("WorkingDay updated successfully, WorkingDay Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkingDay> list() {

		List<WorkingDay> WorkingDaysList = entityManager.createQuery("from WorkingDay").getResultList();
		for (WorkingDay p : WorkingDaysList) {
			logger.info("WorkingDay List::" + p);
		}
		return WorkingDaysList;
	}

	@Override
	public WorkingDay getById(Long id) {

		WorkingDay WorkingDay = (WorkingDay) entityManager.find(WorkingDay.class, id);
		logger.info("WorkingDay loaded successfully, WorkingDay details=" + WorkingDay);
		return WorkingDay;
	}

	@Override
	public void remove(Long id) {

		WorkingDay p = (WorkingDay) entityManager.find(WorkingDay.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("WorkingDay deleted successfully, WorkingDay details=" + p);
	}

	public WorkingDay getByName(String WorkingDayName) {
		//TODO
		return null;
	}

}
