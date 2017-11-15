package com.riadh.mdneedyou.dao;

import java.util.List;

import com.riadh.mdneedyou.genric.Executer;
import com.riadh.mdneedyou.model.OneTreatment;

public interface OneTreatmentDAO extends Executer<OneTreatment> {

	public List<OneTreatment> getByBusiness(Long id);
}
