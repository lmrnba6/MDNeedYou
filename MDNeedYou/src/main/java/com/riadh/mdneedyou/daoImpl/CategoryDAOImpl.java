package com.riadh.mdneedyou.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riadh.mdneedyou.dao.CategoryDAO;
import com.riadh.mdneedyou.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);

	@Autowired
	private EntityManager entityManager;

	

	@Override
	public void add(Category p) {

		entityManager.persist(p);
		logger.info("Category saved successfully, Category Details=" + p);
	}

	@Override
	public void update(Category p) {

		entityManager.merge(p);
		logger.info("Category updated successfully, Category Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {

		List<Category> CategorysList = entityManager.createQuery("from Category").getResultList();
		for (Category p : CategorysList) {
			logger.info("Category List::" + p);
		}
		return CategorysList;
	}

	@Override
	public Category getById(Long id) {

		Category Category = (Category) entityManager.find(Category.class, id);
		logger.info("Category loaded successfully, Category details=" + Category);
		return Category;
	}

	@Override
	public void remove(Long id) {

		Category p = (Category) entityManager.find(Category.class, id);
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("Category deleted successfully, Category details=" + p);
	}

	public Category getByName(String CategoryName) {
		//TODO
		return null;
	}

}
