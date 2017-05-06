package com.riadh.mdneedyou.dao;

import com.riadh.mdneedyou.genric.Executer;
import com.riadh.mdneedyou.model.User;

public interface UserDAO extends Executer<User> {

	public boolean checkLogin(String userName, String userPassword);

}
