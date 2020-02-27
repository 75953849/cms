package com.briup.service;

import java.util.List;

import com.briup.bean.Category;
import com.briup.exception.CustomerException;

public interface ICategoryService {
	public List<Category> findAll();
	
	public void deleteById(int id) throws Exception;
	
	public void saveOrUpdate(Category category) throws Exception;

	public Category findById(int id) throws Exception;
}
