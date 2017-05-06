package com.riadh.mdneedyou.service;

import com.riadh.mdneedyou.genric.Executer;
import com.riadh.mdneedyou.model.User;

public interface UserService extends Executer<User> {

	public boolean checkLogin(String userName, String userPassword);

}
