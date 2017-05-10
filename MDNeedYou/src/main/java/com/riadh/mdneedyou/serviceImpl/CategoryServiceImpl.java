package com.riadh.mdneedyou.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riadh.mdneedyou.dao.CategoryDAO;
import com.riadh.mdneedyou.model.Category;
import com.riadh.mdneedyou.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO CategoryDAO;

	@Override
	public void add(Category p) {
		this.CategoryDAO.add(p);
	}

	@Override
	public void update(Category p) {
		this.CategoryDAO.update(p);
	}

	@Override
	public List<Category> list() {
		return this.CategoryDAO.list();
	}

	@Override
	public Category getById(Long id) {
		return this.CategoryDAO.getById(id);
	}

	@Override
	public void remove(Long id) {
		this.CategoryDAO.remove(id);
	}

	@Override
	public Category getByName(String CategoryName) {

		return this.CategoryDAO.getByName(CategoryName);
	}

}
