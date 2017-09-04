package com.riadh.mdneedyou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.MedecinDAO;
import com.riadh.mdneedyou.model.Medecin;
import com.riadh.mdneedyou.service.MedecinService;

@Service
@Transactional
public class MedecinServiceImpl implements MedecinService {

	@Autowired
	private MedecinDAO MedecinDAO;

	@Override
	public void add(Medecin p) {
		this.MedecinDAO.add(p);
	}

	@Override
	public void update(Medecin p) {
		this.MedecinDAO.update(p);
	}

	@Override
	public List<Medecin> list() {
		return this.MedecinDAO.list();
	}

	@Override
	public Medecin getById(Long id) {
		return this.MedecinDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.MedecinDAO.remove(id);
	}

	@Override
	public Medecin getByName(String MedecinName) {

		return this.MedecinDAO.getByName(MedecinName);
	}
	
	@Override
	public List<Medecin> getByBusiness(Long id){
		return this.MedecinDAO.getByBusiness(id);
	}

}
