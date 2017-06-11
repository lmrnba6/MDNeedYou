package com.riadh.mdneedyou.serviceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.ReservationDAO;
import com.riadh.mdneedyou.model.Reservation;
import com.riadh.mdneedyou.service.ReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDAO ReservationDAO;

	@Override
	public void add(Reservation p) {
		this.ReservationDAO.add(p);
	}

	@Override
	public void update(Reservation p) {
		this.ReservationDAO.update(p);
	}

	@Override
	public List<Reservation> list() {
		return this.ReservationDAO.list();
	}

	@Override
	public Reservation getById(Long id) {
		return this.ReservationDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.ReservationDAO.remove(id);
	}

	@Override
	public Reservation getByName(String ReservationName) {

		return this.ReservationDAO.getByName(ReservationName);
	}
	
	@Override
	public List<Reservation> getByBusiness(Long id){
		return this.ReservationDAO.getByBusiness(id);
	}
	
	@Override
	public List<Reservation> getByDate(Date date, Long id){
		return this.ReservationDAO.getByDate(date, id);
	}

}
