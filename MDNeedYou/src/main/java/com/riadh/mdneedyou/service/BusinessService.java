package com.riadh.mdneedyou.service;

import java.util.List;

import com.riadh.mdneedyou.genric.Executer;
import com.riadh.mdneedyou.model.Business;
import com.riadh.mdneedyou.model.User;

public interface BusinessService extends Executer<Business> {

	public List<Business> listByCity(String city);
	public Business login(String email, String password);
}
