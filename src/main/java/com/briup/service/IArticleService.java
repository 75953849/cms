package com.briup.service;

import java.util.List;

import com.briup.bean.Article;

public interface IArticleService {
	public void saveOrUpdate(Article article) throws Exception;

	public Article findById(int id) throws Exception;

	public List<Article> findAll();
	
	public void deleteById(int id) throws Exception;
}
