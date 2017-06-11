package com.riadh.mdneedyou.daoImpl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.ReservationDAO;
import com.riadh.mdneedyou.model.Reservation;

@Repository
public class ReservationDAOImpl implements ReservationDAO {

	private static final Logger logger = LoggerFactory.getLogger(ReservationDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public void add(Reservation p) {

		entityManager.persist(p);
		logger.info("Reservation saved successfully, Reservation Details=" + p);
	}

	@Override
	public void update(Reservation p) {

		entityManager.merge(p);
		logger.info("Reservation updated successfully, Reservation Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> list() {

		List<Reservation> ReservationsList = entityManager.createQuery("from Reservation").getResultList();
		for (Reservation p : ReservationsList) {
			logger.info("Reservation List::" + p);
		}
		return ReservationsList;
	}

	@Override
	public Reservation getById(Long id) {

		Reservation Reservation = (Reservation) entityManager.find(Reservation.class, id);
		logger.info("Reservation loaded successfully, Reservation details=" + Reservation);
		return Reservation;
	}

	@Override
	public void remove(Long id) {

		Reservation p = (Reservation) entityManager.find(Reservation.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("Reservation deleted successfully, Reservation details=" + p);
	}

	public Reservation getByName(String ReservationName) {
		//TODO
		return null;
	}
	
	public List<Reservation> getByBusiness(Long id) {
		
		@SuppressWarnings("unchecked")
		List<Reservation> ReservationsList = entityManager.createQuery("from Reservation as r where r.businessId = :id").setParameter("id", id).getResultList();
		return ReservationsList;
	}
	
	public List<Reservation> getByDate(Date date, Long id){
	
		@SuppressWarnings("unchecked")
		List<Reservation> ReservationsList = entityManager.createQuery("select r from Reservation as r join r.business as b where r.date = :date and b.businessId = :id").setParameter("date", date).setParameter("id", id).getResultList();
		return ReservationsList;
	}
	
	

}
