package com.riadh.mdneedyou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.OneTreatmentDAO;
import com.riadh.mdneedyou.model.OneTreatment;
import com.riadh.mdneedyou.service.OneTreatmentService;

@Service
@Transactional
public class OneTreatmentServiceImpl implements OneTreatmentService {

	@Autowired
	private OneTreatmentDAO OneTreatmentDAO;

	@Override
	public void add(OneTreatment p) {
		this.OneTreatmentDAO.add(p);
	}

	@Override
	public void update(OneTreatment p) {
		this.OneTreatmentDAO.update(p);
	}

	@Override
	public List<OneTreatment> list() {
		return this.OneTreatmentDAO.list();
	}

	@Override
	public OneTreatment getById(Long id) {
		return this.OneTreatmentDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.OneTreatmentDAO.remove(id);
	}

	@Override
	public OneTreatment getByName(String OneTreatmentName) {

		return this.OneTreatmentDAO.getByName(OneTreatmentName);
	}
	
	@Override
	public List<OneTreatment> getByBusiness(Long id){
		return this.OneTreatmentDAO.getByBusiness(id);
	}

}
