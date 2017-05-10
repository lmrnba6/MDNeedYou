package com.riadh.mdneedyou.dao;

import com.riadh.mdneedyou.genric.Executer;
import com.riadh.mdneedyou.model.Business;

public interface BusinessDAO extends Executer<Business> {

	public boolean checkLogin(String email, String password);
}
