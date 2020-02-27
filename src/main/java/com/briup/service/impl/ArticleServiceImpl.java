package com.briup.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.dao.ArticleDao;
import com.briup.service.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService{

	@Autowired
	private ArticleDao articleDao;
	@Override
	public void saveOrUpdate(Article article) throws Exception {
		// TODO Auto-generated method stub
		if(article!=null) {
			Integer id = article.getId();
			if(id==null) {
				articleDao.save(article);
			}else {
				//根据id查询一该文章
				Article article_db = articleDao.findById(id).get();
				String author = article.getAuthor();
				String title = article.getTitle();
				Category category = article.getCategory();
				if(author!=null) {
					article_db.setAuthor(author);
				}
				if(title!=null) {
					article_db.setTitle(title);
				}
				if(category.getId()!=null) {
					article_db.setCategory(category);
				}
				articleDao.save(article_db);
			}
		}else {
			throw new Exception("参数为空");
		}
	}
	@Override
	public Article findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Article> opt = articleDao.findById(id);
		Article article = opt.isPresent()?opt.get():null;
		if(article!=null) {
			article.setClickTimes(article.getClickTimes()+1);
			articleDao.save(article);
			return article;
		}else {
			throw new Exception("该id在数据库中不存在");
		}
	}
	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		List<Article> list = articleDao.findAll();
		return list;
	}
	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Article> opt = articleDao.findById(id);
		Article article = opt.isPresent()?opt.get():null;
		if(article!=null) {
			articleDao.deleteById(id);
		}else {
			throw new Exception("id在数据库中不存在");
		}
		
			
	}
	
	
	

}
