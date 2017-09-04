package com.riadh.mdneedyou.service;

import java.util.List;

import com.riadh.mdneedyou.genric.Executer;
import com.riadh.mdneedyou.model.Medecin;

public interface MedecinService extends Executer<Medecin> {

	public List<Medecin> getByBusiness(Long id);
}
