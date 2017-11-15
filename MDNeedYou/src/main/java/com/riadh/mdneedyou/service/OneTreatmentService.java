package com.riadh.mdneedyou.service;

import java.util.List;

import com.riadh.mdneedyou.genric.Executer;
import com.riadh.mdneedyou.model.OneTreatment;

public interface OneTreatmentService extends Executer<OneTreatment> {

	public List<OneTreatment> getByBusiness(Long id);
}
