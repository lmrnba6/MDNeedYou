package com.riadh.mdneedyou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.UserDAO;
import com.riadh.mdneedyou.model.User;
import com.riadh.mdneedyou.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void add(User p) {
		this.userDAO.add(p);
	}

	@Override
	public void update(User p) {
		this.userDAO.update(p);
	}

	@Override
	public List<User> list() {
		return this.userDAO.list();
	}

	@Override
	public User getById(Long id) {
		return this.userDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.userDAO.remove(id);
	}

	
	@Override
	public User getByName(String userName) {

		return this.userDAO.getByName(userName);
	}

}
