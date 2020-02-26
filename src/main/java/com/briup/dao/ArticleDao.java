package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Article;

public interface ArticleDao extends JpaRepository<Article, Integer>{

}
