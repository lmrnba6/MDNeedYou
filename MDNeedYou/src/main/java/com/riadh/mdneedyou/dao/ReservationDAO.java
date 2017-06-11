package com.riadh.mdneedyou.dao;

import java.sql.Date;
import java.util.List;

import com.riadh.mdneedyou.genric.Executer;
import com.riadh.mdneedyou.model.Reservation;

public interface ReservationDAO extends Executer<Reservation> {

	public List<Reservation> getByBusiness(Long id);
	public List<Reservation> getByDate(Date date, Long id);

}
