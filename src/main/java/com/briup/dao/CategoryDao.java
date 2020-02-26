package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
