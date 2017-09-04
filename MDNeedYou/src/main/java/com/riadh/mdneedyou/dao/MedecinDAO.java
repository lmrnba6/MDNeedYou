package com.riadh.mdneedyou.dao;

import java.util.List;

import com.riadh.mdneedyou.genric.Executer;
import com.riadh.mdneedyou.model.Medecin;

public interface MedecinDAO extends Executer<Medecin> {

	public List<Medecin> getByBusiness(Long id);
}
