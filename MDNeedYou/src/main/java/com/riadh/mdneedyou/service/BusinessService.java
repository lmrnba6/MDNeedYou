package com.riadh.mdneedyou.service;

import com.riadh.mdneedyou.genric.Executer;
import com.riadh.mdneedyou.model.Business;

public interface BusinessService extends Executer<Business> {

	public boolean checkLogin(String userName, String userPassword);
}
