package com.riadh.mdneedyou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.WorkingDayDAO;
import com.riadh.mdneedyou.model.WorkingDay;
import com.riadh.mdneedyou.service.WorkingDayService;

@Service
@Transactional
public class WorkingDayServiceImpl implements WorkingDayService {

	@Autowired
	private WorkingDayDAO workingDayDAO;

	@Override
	public void add(WorkingDay p) {
		this.workingDayDAO.add(p);
	}

	@Override
	public void update(WorkingDay p) {
		this.workingDayDAO.update(p);
	}

	@Override
	public List<WorkingDay> list() {
		return this.workingDayDAO.list();
	}

	@Override
	public WorkingDay getById(Long id) {
		return this.workingDayDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.workingDayDAO.remove(id);
	}

	
	@Override
	public WorkingDay getByName(String workingDayName) {

		return this.workingDayDAO.getByName(workingDayName);
	}

}
