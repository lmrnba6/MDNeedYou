package com.riadh.mdneedyou.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.UserDAO;
import com.riadh.mdneedyou.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	@Override
	public void add(User p) {

		entityManager.persist(p);
		logger.info("User saved successfully, User Details=" + p);
	}

	@Override
	public void update(User p) {

		entityManager.merge(p);
		logger.info("User updated successfully, User Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {

		List<User> UsersList = entityManager.createQuery("from User").getResultList();
		for (User p : UsersList) {
			logger.info("User List::" + p);
		}
		return UsersList;
	}

	@Override
	public User getById(Long id) {

		User user = (User) entityManager.find(User.class, id);
		logger.info("User loaded successfully, User details=" + user);
		return user;
	}

	@Override
	public void remove(Long id) {

		User p = (User) entityManager.find(User.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("User deleted successfully, User details=" + p);
	}

	@SuppressWarnings("unchecked")
	public User getByName(String name) {

		String SQL_QUERY = "from User u where u.name = :name";
		List<User> userList = entityManager.createQuery(SQL_QUERY).setParameter("name", name).getResultList();

		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

}
