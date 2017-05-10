package com.riadh.mdneedyou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.AvailabilityDAO;
import com.riadh.mdneedyou.model.Availability;
import com.riadh.mdneedyou.service.AvailabilityService;

@Service
@Transactional
public class AvailabilityServiceImpl implements AvailabilityService {

	@Autowired
	private AvailabilityDAO AvailabilityDAO;

	@Override
	public void add(Availability p) {
		this.AvailabilityDAO.add(p);
	}

	@Override
	public void update(Availability p) {
		this.AvailabilityDAO.update(p);
	}

	@Override
	public List<Availability> list() {
		return this.AvailabilityDAO.list();
	}

	@Override
	public Availability getById(Long id) {
		return this.AvailabilityDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.AvailabilityDAO.remove(id);
	}

	@Override
	public Availability getByName(String AvailabilityName) {

		return this.AvailabilityDAO.getByName(AvailabilityName);
	}

}
