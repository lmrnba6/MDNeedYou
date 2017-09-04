package com.riadh.mdneedyou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.TreatmentDAO;
import com.riadh.mdneedyou.model.Treatment;
import com.riadh.mdneedyou.service.TreatmentService;

@Service
@Transactional
public class TreatmentServiceImpl implements TreatmentService {

	@Autowired
	private TreatmentDAO TreatmentDAO;

	@Override
	public void add(Treatment p) {
		this.TreatmentDAO.add(p);
	}

	@Override
	public void update(Treatment p) {
		this.TreatmentDAO.update(p);
	}

	@Override
	public List<Treatment> list() {
		return this.TreatmentDAO.list();
	}

	@Override
	public Treatment getById(Long id) {
		return this.TreatmentDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.TreatmentDAO.remove(id);
	}

	@Override
	public Treatment getByName(String TreatmentName) {

		return this.TreatmentDAO.getByName(TreatmentName);
	}

}
